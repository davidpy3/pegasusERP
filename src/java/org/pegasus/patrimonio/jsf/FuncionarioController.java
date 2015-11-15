package org.pegasus.patrimonio.jsf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.jsuns.X;
import org.pegasus.personal.jpa.Personal;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.PersonalFacadeLocal ejbFacade;

    @ManagedProperty("#{param.dni}")
    private String dni;

    @PostConstruct
    public void init() {
        if (dni != null) {
            personal = ejbFacade.find(dni);
        }
        X.log("personalController.init()" + dni);
    }

    class LazyListModel extends LazyDataModel<Personal> {

        public LazyListModel() {
        }

        @Override
        public Personal getRowData(String rowKey) {
            return ejbFacade.find(dni);
        }

        @Override
        public Object getRowKey(Personal car) {
            return car.getDni();
        }

        @Override
        public List<Personal> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            Object o[]=new Object[]{"SELECT COUNT(t) FROM Personal t WHERE t.funcionario IS NOT NULL"};
            List data = ejbFacade.getResultList("SELECT t FROM Personal t WHERE t.funcionario IS NOT NULL "
                    + "ORDER BY t.nombComp",o,
                    first, pageSize);
            if (getRowCount() <= 0) {
                setRowCount(((Number)o[0]).intValue());
            }
            return data;
        }

    }

    private Personal personal = new Personal();

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void create() {
        X.log("create()");
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        options.put("contentWidth", 800);
        this.personal = new Personal();
        RequestContext.getCurrentInstance().openDialog("/personal/w_nuevo_personal", options, null);
    }

    public void delete() {
        this.ejbFacade.remove(this.ejbFacade.find(dni));
    }

    public Personal getSelected() {
        return personal;
    }

    public void setSelected(Personal personal) {
        this.personal = personal;
    }

    public FuncionarioController() {
    }

    public StreamedContent getStreamedImage() throws FileNotFoundException {
        FacesContext ctx=FacesContext.getCurrentInstance();
//        if(ctx.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE)
//            return new DefaultStreamedContent();
        String path = this.personal != null ? personal.getUbicaFoto() : null;
        File f;
        if (path != null) {
            //P:\FOTOS\00011678.jpg
            System.out.println(path);
            f = new File(path.contains(":")?path.replaceFirst("P:", "F:\\\\pg compil 020414"):
                   "F:\\pg compil 020414\\"+path);
            System.out.println(ctx.getCurrentPhaseId().getName()+">"+f+"<  > exists="+f.exists());
            if (!f.exists()) {
                //f = new File("F:\\pg compil 020414\\Fotos\\NO_IDENTIFICADO.jpg");
            }
        } else {
            f = new File("F:\\pg compil 020414\\Fotos\\NO_IDENTIFICADO.jpg");
        }
        return new DefaultStreamedContent(new FileInputStream(f));
    }

    private LazyDataModel dataModel = null;

    public LazyDataModel<Personal> getDataModel() {
        if (dataModel == null) {
            dataModel = new LazyListModel();
            System.out.println("se creo " + dataModel);
        }
        return dataModel;
    }

}
