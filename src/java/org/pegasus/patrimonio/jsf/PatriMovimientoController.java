package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.PatriMovimiento;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.XMap;
import org.jsuns.util.Func;
import org.pegasus.patrimonio.jpa.PatriMovimientoPK;
import org.pegasus.patrimonio.ejb.PatriMovimientoFacadeLocal;

@Named
@SessionScoped
public class PatriMovimientoController extends AbstractController<PatriMovimiento> implements Serializable {

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPatriMovimientoPK(new PatriMovimientoPK());
    }

    @EJB
    private org.pegasus.patrimonio.ejb.PatriMovimientoFacadeLocal ejbFacade;

    private String anoEje="2014";
    private int bandeja = 2;

    public PatriMovimiento prepareEdit() {
        PatriMovimiento s = super.getSelected();
        setSelected(s = getFacade().prepareEdit(s));
        return s;
    }

    public void bandejaChanged() {
        items = null;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getBandeja() {
        return bandeja;
    }

    public void setBandeja(int bandeja) {
        this.bandeja = bandeja;
    }

    private PatriMovimientoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<PatriMovimiento> getItems() {
        if (items == null) {
            XMap m = new XMap();
            m.put("tipoMov",bandeja);
            m.put("anoEje",anoEje);
            if (bandeja == 2) {
                m.put("estado", '0');
            }
            items =getFacade().load(0, -1, null, m);
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        PatriMovimiento selected = this.getSelected();
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public void autorizar() {
        PatriMovimiento m = this.getSelected();
        System.out.println("=" + m);
        switch (getBandeja()) {
            case PatriMovimiento.GUIAS_DESPLAZAMIENTO:
                if (m.getEstado() == PatriMovimiento.TRAMITE || m.getEstado() == PatriMovimiento.BORRADOR) {

//				IF MessageBox("Confirmar", "Esta seguro que desea Autorizar la Salida de la Guia de Desplazamiento Nº " + &
//					string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
                    m.setFechaReg(Func.getServerDate());
                    m.setEstado(PatriMovimiento.AUTORIZADO);
                    try {
                        getFacade().edit(m);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La Guia de Desplazamiento fue Autorizada Correctamente."));
                    } catch (Exception e) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se pudo relizar la operacion por un error interno."));
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La Guia de Desplazamiento seleccionada ya se encuentra Autoriza o está anulado."));
                }
                break;
            case PatriMovimiento.DEVOLUCION_BIENES_PATRIMONIALES:
////			IF MessageBox("Confirmar", "Esta seguro que desea Autorizar el FUDB Nº "+ &
////				string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
//				open( w_req_autorizar)

//				IF upper(message.stringparm) = f_code(trim(ds_user.object.clave[n_user])) THEN
                this.getFacade().autorizar(m);
//						Messagebox("Aviso", "El FUDB fue Autorizado Satisfactoriamente")
//						dw_1.retrieve(string(ano_eje))
//				}else{
//					messagebox('Identificación', 'La clave de autorización está errada, porfavor vuelva a intentarlo.', StopSign!)
////				}
//			}
        }
    }

    public void anular() {
        PatriMovimiento m = this.getSelected();
        switch (getBandeja()) {
            case PatriMovimiento.GUIAS_DESPLAZAMIENTO:
//                IF MessageBox("Confirmar", "Esta seguro que desea anular la Guia de Desplazamiento Nº "+ &
//				string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
//				open(w_uasa_motivo_anula)
                m.setObservaciones("lo que se obtenga de w_uasa_motivo_anula");
                m.setEstado(PatriMovimiento.BUENA_PRO);
                this.getFacade().edit(m);
//                dw_1.retrieve(string(ano_eje)) 
                break;
            case PatriMovimiento.DEVOLUCION_BIENES_PATRIMONIALES:
                switch (m.getEstado()) {
                    case PatriMovimiento.TRAMITE:
//                        IF MessageBox("Confirmar", "Esta seguro que desea anular el FUDB Nº "+ &
//					string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
//					open(w_uasa_motivo_anula)

                        m.setObservaciones("lo que se obtenga de w_uasa_motivo_anula");
                        m.setEstado(PatriMovimiento.BUENA_PRO);
                        this.getFacade().edit(m);
//						dw_1.retrieve(string(ano_eje))

//				END IF
                        break;
                    case PatriMovimiento.AUTORIZADO:

//				IF MessageBox("Confirmar", "Esta seguro que desea anular el FUDB Nº "+ &
//					
//                                string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
//					open(w_uasa_motivo_anula)
                        m.setObservaciones("lo que se obtenga de w_uasa_motivo_anula");
                        this.getFacade().anular(m);
//						Messagebox("Aviso", "El FUDB fue anulado correctamente")
//						dw_1.retrieve(string(ano_eje))						
//					END IF   
                }
        }
    }

    public void retornar() {
        PatriMovimiento m = this.getSelected();
        switch (getBandeja()) {
            case PatriMovimiento.GUIAS_DESPLAZAMIENTO:
                if (m.getEstado() == PatriMovimiento.AUTORIZADO) {
                    //IF MessageBox("Confirmar", "Esta seguro que desea Cerrar la Guia de Desplazamiento Nº "+ &
//					string(dw_1.object.num_mov[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
                    m.setFechaRetorno(Func.getServerDate());
                    m.setEstado(PatriMovimiento.ADJUDICADO);
                    try {
                        getFacade().edit(m);
                        //messagebox('AVISO', 'La Guia de Desplazamiento fue Cerrada Correctamente')
                        //dw_1.retrieve(string(ano_eje))
                    } catch (Exception e) {
                        //messagebox('AVISO', 'No se pudo Cerrar Guia de Desplazamiento')
                    }
                    //}
                } else {
                    //Messagebox("Validacion", "No se puedne Cerrar Guias que aun no estan Autorizadas o que estan Cerradas")
                }
        }
    }

    @Override
    public void create() {
        super.create(); //To change body of generated methods, choose Tools | Templates.
//    str_patrimonio str_guia, str_fudb
//
//CHOOSE CASE bandeja
//	case 1
//		str_guia.ano_eje = string(em_1.text)
//		str_guia.num_mov = '-999'
//		str_guia.tipo_oper = 1
//
//
//		OpenWithParm(w_guia_deplazamiento, str_guia)
//		
//		
//		dw_1.retrieve(string(ano_eje))
//	case 2
//		str_fudb.ano_eje = string(em_1.text)
//		str_fudb.num_mov = '-999'
//		str_fudb.tipo_oper = 1
//		
//		open(w_traslado_bienes)
//		//OpenWithParm(w_formato_devol_bienes, str_fudb)
//		dw_1.retrieve(string(ano_eje))
//end choose

    }

    public void preview() {
        PatriMovimiento m = this.getSelected();
        switch (getBandeja()) {
            case PatriMovimiento.GUIAS_DESPLAZAMIENTO:
//			str_mov.tipo_oper = 1
//			OpenSheetWithParm(w_seleccionar_tipo_rpte2, str_mov, w_patrimonio, 2, Original!)
                break;
            case PatriMovimiento.DEVOLUCION_BIENES_PATRIMONIALES:
            //			str_mov.tipo_oper = 2	
//			OpenSheetWithParm(w_seleccionar_tipo_rpte2, str_mov, w_patrimonio, 2, Original!)
        }

//	case 1
//		rb_1.enabled = false
//		rb_3.checked = true
//		
//	case 2
        //             rb_1.checked = true
//		rb_2.enabled = false
//		rb_3.enabled = false
//		
//        IF rb_1.checked then Guia de Desplazamiento
//
//	OpenSheetWithParm(w_rpte_fudb, istr_rpte, w_patrimonio, 2, Original!)
//		
//elseif rb_2.checked then Bienes sin Retornar
//
//	OpenSheetWithParm(w_rpte_bienes_sinretornar, istr_rpte, w_patrimonio, 2, Original!)
//ELSEIF rb_3.checked then Formato Unico de Devolución de Bienes
//	
//	OpenSheetWithParm(w_rpte_guia_desplazamiento, istr_rpte, w_patrimonio, 2, Original!)
//end if
    }

    public PatriMovimiento getPatriMovimiento(org.pegasus.patrimonio.jpa.PatriMovimientoPK id) {
        return getFacade().find(id);
    }

    @FacesConverter(forClass = PatriMovimiento.class)
    public static class PatriMovimientoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PatriMovimientoController controller = (PatriMovimientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "patriMovimientoController");
            return controller.getPatriMovimiento(getKey(value));
        }

        org.pegasus.patrimonio.jpa.PatriMovimientoPK getKey(String value) {
            org.pegasus.patrimonio.jpa.PatriMovimientoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.PatriMovimientoPK();
            key.setAnoEje(values[0]);
            key.setTipoMov(new Character(values[1].charAt(0)));
            key.setNumMov(values[2]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.PatriMovimientoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getTipoMov());
            sb.append(SEPARATOR);
            sb.append(value.getNumMov());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PatriMovimiento) {
                PatriMovimiento o = (PatriMovimiento) object;
                return getStringKey(o.getPatriMovimientoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PatriMovimiento.class.getName()});
                return null;
            }
        }

    }

}
