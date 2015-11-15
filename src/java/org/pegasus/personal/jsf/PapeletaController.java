package org.pegasus.personal.jsf;

import java.io.ByteArrayInputStream;
import org.pegasus.personal.jpa.Papeleta;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.AbstractController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ComponentSystemEvent;
import javax.sql.DataSource;
import org.jsuns.jreport.JReportAction;
import org.jsuns.util.XMap;
import org.pegasus.personal.ejb.PapeletaFacadeLocal;
import org.pegasus.personal.jpa.PapeletaPK;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named("papeletaController")
@SessionScoped
public class PapeletaController extends AbstractController<Papeleta> implements Serializable {

    public Object[] getRegularizaList(){
        return (new Object[]{
            new Object[]{"1","Papeleta Normal"},
            new Object[]{"2","Papeleta de Regularización"},
        });
    }
    
    public Object[] getPeriodoList(){
        return (new Object[]{
            new Object[]{"1","Por Horas"},
            new Object[]{"2","Por Dias"},
        });
    }  
    
    @EJB
    private org.pegasus.personal.ejb.PapeletaFacadeLocal ejbFacade;

    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setPapeletaPK(new org.pegasus.personal.jpa.PapeletaPK("2015",null));
    }

        
    public void anular(){
        Papeleta p=this.getSelected();
        if(p.getEstado()=='0'||p.getEstado()=='2'){
        	
//		IF MessageBox("Confirmar", "Esta seguro que desea anular la PAPELETA DE SALIDA Nº "+ &
//				string(dw_1.object.n_papeleta[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
//				open(w_uasa_motivo_anula)
                                String motivo=null;
                                p.setObservaciones(motivo);
                                p.setEstado('9');
                                persist(PersistAction.UPDATE,"Papaleta Anulada!");
//		END IF
                        }else{
//		Messagebox("Validación", "No se pueden Anular Papeletas que ya han sido iniciadas o Concluidas")
                        }
    }

    public void autorizar(){
        Papeleta p=this.getSelected();
        if(p.getEstado()=='0'){
            /*
            IF MessageBox("Confirmar", "Esta seguro que desea Autorizar la Papeleta de salida Nº "+ &
			string(dw_1.object.n_papeleta[dw_1.getrow()]) +" ?", Question!, YesNo!, 2)	= 1 THEN
			
			//ds_user
			
			IF ds_user.object.autoriza[n_user] = 'S' then
				open( w_req_autorizar)
			
				IF upper(message.stringparm) = f_code(trim(ds_user.object.clave[n_user])) THEN
			
					IF dw_1.object.regulariza[dw_1.getrow()] = '2' THEN //Papeleta de regularizacion
						
						dw_1.object.estado[dw_1.getrow()] = '4'
			
	
					ELSE //Papeletas Normales
								
					
						IF dw_1.object.peri_pape[dw_1.getrow()] = '1' THEN //Papeleta x Horas
					
							CHOOSE CASE DaysAfter (date(dw_1.object.fecha_pape[dw_1.getrow()]) , date(dw_1.object.fecha_del[dw_1.getrow()]))
					
								case 0 //MISMO DIA
									dw_1.object.estado[dw_1.getrow()] = '2'
							
								case IS >= 1
							
									dw_1.object.estado[dw_1.getrow()] = '3'
							
									//setear hora De inicio en papeleta
							
									dw_1.object.hora_ini[dw_1.getrow()] = datetime( date(dw_1.object.fecha_del[dw_1.getrow()]), time("08:00:00"))
						
							END CHOOSE
				
						ELSE  //2. Papeleta x Dia
							
							IF  DaysAfter (date(dw_1.object.fecha_pape[dw_1.getrow()]) , date(dw_1.object.fecha_del[dw_1.getrow()])) = 0 THEN

								dw_1.object.estado[dw_1.getrow()] = '2'
								
							ELSEIF DaysAfter (date(dw_1.object.fecha_DEL[dw_1.getrow()]) , date(dw_1.object.fecha_AL[dw_1.getrow()])) > 1 THEN
	
								dw_1.object.estado[dw_1.getrow()] = '4'
							
								//setear hora de inicio y fin en la papeleta
								dw_1.object.hora_ini[dw_1.getrow()] = datetime( date(dw_1.object.fecha_del[dw_1.getrow()]), time("08:00:00"))
								dw_1.object.fhora_fin[dw_1.getrow()] = datetime( date(dw_1.object.fecha_al[dw_1.getrow()]), time("17:00:00"))
									
								
						
							END IF
						
						END IF
					
					END IF  // Fin papeleta de regularizacion
			
			
			//************************ Bloque para setear todas las marcaciones faltantes ******************
					if dw_1.update() = 1 then
						commit;
						
						f_set_marcaciones(dw_1.getitemdatetime( dw_1.getrow(), 'fecha_del'), &
										dw_1.getitemdatetime( dw_1.getrow(), 'fecha_al'), &
										dw_1.getitemdatetime( dw_1.getrow(), 'fecha_pape'), &
										dw_1.getitemstring( dw_1.getrow(), 'dni') )
										
						Messagebox("Aviso", "Se Autorizó satisfactoriamente la papeleta", Information! )
					else
						rollback;
						Messagebox("Error", "No se pudo Autorizar la papeleta", StopSign! )
					end if
				
				//***************************************************************************************
				
				ELSE //Error de clave
				
					messagebox('Identificación', 'La clave de autorización está errada, porfavor vuelva a intentarlo.', StopSign!)
				
				END IF
			
			ELSE //condiconal autoriza
				Messagebox("Validación", "Usted no tiene permisos para Autorizar Papeletas", StopSign!)
			END IF
			
		END IF  //END IF DE LA MESAGE CONFIRMACION

            */
        }else{
//            	Messagebox("Validación", "Solo se puede autorizar papeletas en estado de borrador", StopSign!)
	
        }
    }
    
    private PapeletaFacadeLocal getFacade() {
        return ejbFacade;
    }

    
    
    public List<Papeleta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Papeleta selected = this.getSelected();
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

    public Papeleta getPapeleta(org.pegasus.personal.jpa.PapeletaPK id) {
        return getFacade().find(id);
    }

    public List<Papeleta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Papeleta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Papeleta.class)
    public static class PapeletaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PapeletaController controller = (PapeletaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "papeletaController");
            return controller.getPapeleta(getKey(value));
        }

        org.pegasus.personal.jpa.PapeletaPK getKey(String value) {
            org.pegasus.personal.jpa.PapeletaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.PapeletaPK();
            key.setAnoEje(values[0]);
            key.setNPapeleta(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.PapeletaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNPapeleta());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Papeleta) {
                Papeleta o = (Papeleta) object;
                return getStringKey(o.getPapeletaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Papeleta.class.getName()});
                return null;
            }
        }

    }
    
    @ManagedProperty(value="#{param.papeletaPK}")
    private String papeletaPK;
    
 private StreamedContent content;

    public StreamedContent getContent() {
        return content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    public void onPrerender(ComponentSystemEvent event) {
        try {
            ArrayList l=new ArrayList();
            
            if(this.getSelected()==null){
                String[] p=papeletaPK.split("-");
                l.add(this.getFacade().find(new PapeletaPK(p[0],p[1])));
            }else
            l.add(this.getSelected());
            
            System.out.println("d="+l);
            
            content = new DefaultStreamedContent(new ByteArrayInputStream(
                    JReportAction.export(
                            JReportAction.getJasperReport(Object.class,
                                    "/org/munisoft/personal/jr/dw_reporte_papeleta.jasper", 0), 
                            new XMap(DataSource.class,l), "pdf")
                    .toByteArray()
            ), "application/pdf");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
