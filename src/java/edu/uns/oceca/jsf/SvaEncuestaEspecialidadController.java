package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaEncuestaEspecialidad;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaEncuestaEspecialidadFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.jsuns.util.AbstractController;

@Named("svaEncuestaEspecialidadController")
@SessionScoped
public class SvaEncuestaEspecialidadController extends AbstractController<SvaEncuestaEspecialidad> implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaEncuestaEspecialidadFacadeLocal ejbFacade;

    private SvaEncuestaEspecialidadFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List getPreguntaList(){
        SvaEncuestaEspecialidad selected=getSelected();
        
        List l=selected.getPreguntaList();
        if(l==null){
            l=getFacade().load(selected).getPreguntaList();
        }
        return l;
    }
    
   
    
    public List<SvaEncuestaEspecialidad> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        SvaEncuestaEspecialidad selected=getSelected();
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

    public SvaEncuestaEspecialidad getSvaEncuestaEspecialidad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SvaEncuestaEspecialidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaEncuestaEspecialidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaEncuestaEspecialidad.class)
    public static class SvaEncuestaEspecialidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaEncuestaEspecialidadController controller = (SvaEncuestaEspecialidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaEncuestaEspecialidadController");
            return controller.getSvaEncuestaEspecialidad(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SvaEncuestaEspecialidad) {
                SvaEncuestaEspecialidad o = (SvaEncuestaEspecialidad) object;
                return getStringKey(o.getIdEncuesta());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaEncuestaEspecialidad.class.getName()});
                return null;
            }
        }

    }

/*private final qRespuestaPreguntaEspecialidad qRespuestaPreguntaEspecialidad=new qRespuestaPreguntaEspecialidad();
    private final qPreguntasVigente_X_Cuestionario qPreguntasFuenteVigente_X_Encuesta=new qPreguntasVigente_X_Cuestionario();
    private final qEncuesta qEncuesta=new qEncuesta();
    private final qEncuestaParticipacion qEncuestaParticipacion=new qEncuestaParticipacion();
    private final qQuizOptionList qQuizOptionList=new qQuizOptionList();
    private final qQuizOption qQuizOption=new qQuizOption();
    private static Tag periodo;

    public static Tag getCurrentPeriod(HttpServletRequest request){
        if(periodo==null){
            EntityManager em=JPA.getInstance().getEntityManager();
            List data= em.createNativeQuery("SELECT DISTINCT pa.id_acper,pa.cod_acper "
                + "FROM sva_encuesta_especialidad ee,apc_periodo_academico pa  "
                + " WHERE activo=1 AND "
                    + "(pa.id_acper=ee.id_acper OR "
                    + "(ee.id_acper=0 AND pa.cod_anio=year(ee.fecha_ini) AND pa.aperturado=1 AND pa.finalizado=0)"
                    + ")").getResultList();
            if(data.size()>0){
                Object[] d=(Object[])data.get(0);
                periodo=new Tag(d[0],d[1]);
            }else{
                periodo=new Tag(null,null);
            }
        }
        return periodo;
    }

    private static final String sqlPeriodos="SELECT id_acper,cod_acper,id_ambito from apc_periodo_academico WHERE cod_sec in(1,2) AND id_ambito=11 order by cod_acper";
    private qEncuestaParticipacion0 qEncuestaParticipacion0=new qEncuestaParticipacion0();

    public Map getRoles(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
        if(XUtil.intValue(user.getIdDir())>0){
            if(true||encuestas==null){
//                las encuestas activas sin importar el periodo
                encuestas=_JDBC.getResultList(_JDBC.getCnx(request).createStatement().executeQuery(_JDBC.sql("SELECT "
                        + "id_encuesta,"
                        + "sva_encuesta_especialidad.id_especialidad,"
                        + "id_cuestionario,"
                        + "case when sva_encuesta_especialidad.id_especialidad=0 THEN "
                        + "apc_periodo_academico.cod_acper ELSE "
                        + "string(aps_especialidad.especialidad,' ',apc_periodo_academico.cod_acper) "
                        + "end "
                        + "encuesta "
                        + "FROM "
                        + "sva_encuesta_especialidad "
                        + "LEFT OUTER JOIN aps_especialidad ON aps_especialidad.id_especialidad=sva_encuesta_especialidad.id_especialidad "
                        + "LEFT OUTER JOIN apc_periodo_academico ON apc_periodo_academico.id_acper=sva_encuesta_especialidad.id_acper "
                        + "WHERE activo=1")),true);
                request.getSession().removeAttribute("#rmap");
            }
            
            
            Map<Object,List<Character>> rmap=(Map<Object, List<Character>>) request.getSession().getAttribute("#rmap");
            if(rmap==null){
                Connection cnx=JPA.getInstance().getConnection();
                Statement stmt=cnx.createStatement();
                rmap=new HashMap();
                ResultSet rs=stmt.executeQuery(JServlet.print("SELECT "
                        + "id_tipo "
                        + "FROM esc_personal "
                        + "INNER JOIN esc_estado_trabajador ON esc_estado_trabajador.activo=1 "
                        + "AND esc_estado_trabajador.id_estado=esc_personal.id_estado WHERE id_dir="+user.getIdDir()).toString());
                if(rs.next()){
                    switch(rs.getInt("id_tipo")){
                        case 2://DOCENTE
                            break;
                        default:
                            List l=rmap.get(0);
                            if(l==null)rmap.put(0,l=new ArrayList());
                            if(!l.contains('A'))l.add('A');
                    }
                }
                Tag acper=getCurrentPeriod(request);
                stmt=cnx.createStatement();
                String q="SELECT DISTINCT crl_carga_lectiva_det.id_esp "
                        + "FROM crl_carga_lectiva "
                        + "INNER join crl_carga_lectiva_cab ON crl_carga_lectiva_cab.id_carglect=crl_carga_lectiva.id_carglect "
                        + "AND crl_carga_lectiva_cab.id_dir="+user.getIdDir()+" "
                        + "INNER join crl_carga_lectiva_det ON NOT crl_carga_lectiva_det.id_estado='X' AND crl_carga_lectiva_det.uso>0 AND crl_carga_lectiva_cab.id_clcab=crl_carga_lectiva_det.id_clcab "
                        + "WHERE id_acper="+acper.getId();
                X.log("acper="+acper+" q="+q);
                rs=stmt.executeQuery(q);
                //guarda todas las especialidades en que tiene carga lectiva el docente
                while(rs.next()){
                    List l=rmap.get(rs.getInt("id_esp"));
                    if(l==null)rmap.put(rs.getInt("id_esp"),l=new ArrayList());
                    if(!l.contains('D'))l.add('D');
                }
                rs=stmt.executeQuery("SELECT DISTINCT fxa_estudiante.id_acexp,fxa_estudiante.id_especialidad,fxa_egresado.id_acexp id_egresado "
                        + "FROM "
                        + "fxa_estudiante "
                        + " left outer join fxa_egresado ON fxa_estudiante.id_acexp=fxa_egresado.id_acexp "
                        + "WHERE id_direstudiante="+user.getIdDir());
                Statement stmt2=_JDBC.getCnx(request).createStatement();
                while(rs.next()){
                    ResultSet rs2=stmt2.executeQuery("SELECT DISTINCT id_especialidad,id_acexp "
                            + "FROM mta_matricula_cab "
                        + " WHERE mta_matricula_cab.id_acper="+acper.getId()+" AND id_acexp="+rs.getInt(1));
                    int id_especialidad=rs.getInt("id_especialidad");
                    List l=rmap.get(id_especialidad);
                    if(l==null)rmap.put(id_especialidad,l=new ArrayList());
                    if(rs2.next()){
                        Object id_acexp=rs2.getObject(2);
                        if(!l.contains('E'))l.add('E');
                        rs=stmt2.executeQuery("SELECT DISTINCT id_acexp FROM ocbu_comensal WHERE id_estado='A' AND id_acexp="+id_acexp);
                        if(rs.next()&&!l.contains('C'))l.add('C');
                        rs=stmt2.executeQuery("SELECT DISTINCT id_acexp FROM ocbu_bolsista WHERE id_estado='A' AND id_acexp="+id_acexp);
                        if(rs.next()&&!l.contains('B'))l.add('B');
                    }else if(rs.getInt(3)>0){
                        if(!l.contains('S'))l.add('S');
                    }
                }
                //si no tiene roles para algo la unica opcion de agregarlo
                //                es q tenga una participacion registrada
                for(List roles:rmap.values()){
                    if(roles.isEmpty()){
                        //Si no se tiene role para la encuesta se considerara como grupo de interes
                        //esto genera controversia puesto q los grupos de interes podrian ser especificos
                        //y determinarlos dependeria de q esten en registro
                        roles.add('G');
                    }
                }
                request.getSession().setAttribute("#rmap",rmap);
                List id_encuesta=new ArrayList();
                for(Object[] row:(List<Object[]>)encuestas){
                    if(XUtil.intValue(row[2])==1)
                        id_encuesta.add(row[0]);
                }
                request.setAttribute(X.FILTERS,new XMap("id_dir",user.getIdDir(),"id_encuesta",id_encuesta));
                List<Object[]> participacion=_JDBC.getResultList(request,qEncuestaParticipacion0);
                for(Object[] e:(List<Object[]>)encuestas){
                    List r=rmap.get(e[1]);
                    int p=-1;
                    for(int i=0;i<participacion.size();i++){
                        if(participacion.get(i)[1].equals(e[0])){
                            participacion.get(i)[5]=e;
                            p=i;break;
                        }
                    }
//                  en caso todavia no se ha registrado0 a
                    if(r!=null&&r.size()>0&&p==-1){
                        participacion.add(new Object[]{null,e[0],e[1],0,r,e,null,null,user.getIdDir(),null});
                    }
                }
                
                Object m=router.getModule(request,response,"oceda.encuesta");
                m.getClass().getMethod("ask",HttpServletRequest.class,
                        HttpServletResponse.class,
                        User.class,
                        List.class,
                        int.class).invoke(m,request,response,user,participacion,0);
                request.getSession().setAttribute("#participacion",participacion);
                int n=0;
                for(Object[] r:participacion){
                    r[1]=(++n);
                }
//                X.alert(X.gson.toJson(participacion));
            
            }

            return rmap;
        }else{
            return Collections.EMPTY_MAP;
        }
    }

    public static List encuestas;

    public void formEncuesta(HttpServletRequest request,HttpServletResponse response,Object id_encuesta) throws Exception{
        request.setAttribute("include","<script type='text/javascript' src='"+X.url("ux/jsuns.js")+"'></script>");
        SgcEncuestaEspecialidad encuesta=JPA.getInstance().get(SgcEncuestaEspecialidad.class,id_encuesta);
        User user=(User) request.getSession().getAttribute(X.USER);
        EntityManager jpa=JPA.getInstance().getEntityManager();
        String[] q=(String[])request.getAttribute(X.Q);
        if("update".equalsIgnoreCase(request.getParameter("action"))){
            JPA.getInstance().getTransaction(this);
            try{
                X.copy(request,encuesta);
                encuesta.setActivo(encuesta.getEstado()=='A');
                if(encuesta.getIdEncuesta()==null){
                    encuesta.setFechaReg(new java.util.Date());
                    encuesta.setIdCreador(user.getIdDir());
                    jpa.persist(encuesta);
                }else{
                    jpa.merge(encuesta);
                }
                router.commit(request,response,this,false);
                encuestas=null;
                return;
            }catch(Exception e){
                JPA.getInstance().rollback(this,e);
            }
        }
        if(encuesta.getIdEncuesta()!=null)request.setAttribute("title",getEncuestaTitle(request, response, id_encuesta));
        Object embed=X.toText(request.getAttribute("#embed"));
        request.setAttribute("id_especialidad",encuesta.getIdEspecialidad());
        String body="<style>"
        + ".i-start{background-image:url("+X.url("images/play.png")+");}"
        + ".i-stop{background-image:url("+X.url("images/pause.png")+");}"
        + "</style><div id='form"+embed+"'></div><div id='grid"+embed+"'></div>";
        body+="<script>_.x(function(){"
        + "_.w('jsform',{"
                  + "url:'"+X.url(request)+"',"
                + "items:["
        + "{xtype:'jsfieldcontainer',items:["
        + ((XAction)router.getModule(request,"oceda")).getComponent(request,response,user)
        + "]},"
        + "{xtype:'jsfieldcontainer',items:[{"
        + "xtype:'datefield',name:'fecha_ini',value:'"+XDate.toString(encuesta.getFechaIni())+"'"
        + "},"
        + "{xtype:'datefield',name:'fecha_fin',value:'"+XDate.toString(encuesta.getFechaFin())+"'}"
        + "]},"
        + "{xtype:'textarea',name:'observacion',value:'"+JServlet.toJS(encuesta.getObservacion())+"'},"
        + "{xtype:'numberfield',name:'id_editor',value:'"+encuesta.getIdEditor()+"'},"
        + "{xtype:'numberfield',name:'id_creador',value:'"+encuesta.getIdCreador()+"'},"
        + "{xtype:'jsfieldcontainer',items:["
        + "{xtype:'jscombobox',name:'id_cuestionario',"+(encuesta.getIdCuestionario()>0?"value:"+encuesta.getIdCuestionario()+",":"")+"fieldLabel:'Formato',"
        + "store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_cuestionario,nombre FROM quiz_cuestionario ORDER BY nombre").getResultList())+",fields: ['v','d']})},"
        + "{xtype:'jscombobox',name:'estado',value:'"+encuesta.getEstado()+"'}"
        + "]}"
        + "],buttons:["
        + "{xtype:'jssave'}"
        + (encuesta.getIdEncuesta()!=null?",{xtype:'jsdelete'}":"")
        + "]}); "
        + "})</script>";
        request.setAttribute("body", body);
    }

    public Object block(HttpServletRequest request,String op,Object delta){
        if("list".equals(op)){
            Map<String,Map> blocks=(Map)request.getAttribute(BlockAction.BLOCKS);
////             Too dynamic to cache.
            blocks.put("0",new XMap(
                "info","Encuestas",
//                 Menu blocks can't be cached because each menu item can have
//                 a custom access callback. menu.inc manages its own caching.
                "cache",BlockAction.BLOCK_NO_CACHE
            ));
            return blocks;
        }else if("view".equals(op)){
            User user=(User)request.getSession().getAttribute(X.USER);
            try{
                Map<Object,List<Character>> rmap=getRoles(request,null,user);
                HttpSession ss=request.getSession();
                List participacion=(List) ss.getAttribute("#participacion");
                if(
                        (rmap!=null&&rmap.size()>0)||
                        (participacion!=null&&participacion.size()>0)){
                    switch(XUtil.intValue(delta)){
                        case 0:
                            try{
                                return new XMap("content",
                                    "<a class=\"dark_box\" href=\""+X.url("ask")+"\"><img width=\"100%\" " + "src=\"http://1.bp.blogspot.com/_1ti4-way3Z4/TMDnU5R_VsI/AAAAAAAAAMs/7Dujx0pMkdY/s320/evaluacion.jpg\"><br>SISTEMA VIRTUAL DE AUTOEVALUACION</a>");
                            }catch(Exception ex){
                                X.alert(request,ex);
                            }
                    }
                }
            }catch(Exception e){
                X.alert(request,e);
                return new XMap("content",e);
            }
        }
        return null;
    }

    private void viewCuestionario(HttpServletRequest request, HttpServletResponse response,Object id_cuestio) throws Exception {
        int id_cuestionario=XUtil.intValue(id_cuestio);
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT * FROM quiz_cuestionario WHERE id_cuestionario="+id_cuestionario);
        if(!rs.next())throw JServlet.PageNoFoundException;
        request.setAttribute("title",rs.getObject("nombre"));
        String q[]=(String[])request.getAttribute(X.Q);
        List roles=null;
        Statement stmt=_JDBC.getCnx(request).createStatement();
        boolean ask=request.getAttribute("ask")!=null;
        Object embed=X.toText(request.getAttribute("#embed"));
        boolean preview=true;
        if(preview){
            roles=new ArrayList();
            String rol[]=request.getParameterValues("rol");
            if(rol!=null)
                for(String r:rol){
                    roles.add(r.charAt(0));
                }
        }
        String op="";
        boolean cerrado=false;
        if(!XUtil.isEmpty(roles)){
            for(Object r:roles){
                op+=" OR "+r+"=1";
            }
            if(op.length()>1)op=op.substring(3);
        }
        if(ask&&XUtil.isEmpty(roles))throw JServlet.AccessDeniedException;
        String controls="";
        if(!ask&&preview){
//            List<Object[]> data=((SVAServlet)((JServlet)request.getAttribute(JSCore.ROUTER)).getModule("sva", request, response)).getTypes(request, id_cuestionario);
//            if(data.size()>1){
//                for(Object row[]:data){
//                    boolean ck=false;
//                    for(Object r:roles){
//                        if((((Character)r)).charValue()==row[0].toString().charAt(0)){
//                            ck=true;
//                            break;
//                        }
//                    }
//                    controls+="{boxLabel:'"+row[1]+"',inputValue:'"+row[0]+"',checked:"+ck+"},";
//                }
//                controls="_.w('fieldset',{renderTo:'filter"+embed+"',margin:'0 0 18 0',collapsible:true,type:'vbox',defaults:{anchor:'100%'},style:'margin-right:2px',title:'Tipo de Participante',items:["
//                    + "{xtype:'jsform',url:'"+JSCore.url(request)+"',standardSubmit: true,margin:0,buttonAlign:'right',renderTo:false,items:["
//                        + "{xtype:'checkboxgroup',columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
//                            + controls.substring(0,controls.length()-1)
//                        + "]},"
//                    + "],buttons:["
//                        + "{xtype:'jsbutton',iconCls:'i-refresh',text:'Actualizar vista previa',anchor:false,handler:function(b){b.up('form').save();}}"
//                    + "]}"
//                + "]});";
//              controls="<div id='filter"+embed+"'></div><script>_.x(function(){"+controls+"})</script>";
//            }
        }
        ArrayList<Object[]> pregunta=new ArrayList();
        ArrayList opciones=new ArrayList();

        rs=_JDBC.getCnx(request).createStatement().executeQuery(JServlet.print("SELECT quiz_pregunta.* FROM quiz_pregunta "
            + "LEFT OUTER JOIN sgc_fuente_pregunta ON sgc_fuente_pregunta.id_pregunta=quiz_pregunta.id_pregunta "
            + "WHERE id_cuestionario="+id_cuestionario+" "
            + (op.length()>0?"AND (sgc_fuente_pregunta.id_fuente IS null OR "+op+") ":"")
            + "ORDER BY numero,quiz_pregunta.id_pregunta").toString());
        List asignaturas=new ArrayList();
        String content="";
        List id_pregunta_l=new ArrayList();
        while(rs.next()){
            id_pregunta_l.add(rs.getInt("id_pregunta"));
            ArrayList items=new ArrayList();
            ResultSet rs2=stmt.executeQuery("SELECT id_item,id_pregunta,descripcion,id_lista FROM quiz_pregunta_item WHERE id_pregunta="+rs.getInt("id_pregunta")+" ORDER BY id_item");
            while(rs2.next()){
                opciones.add(rs2.getInt("id_lista"));
                items.add(new Object[]{rs2.getInt("id_item"),rs2.getInt("id_lista"),rs2.getString("descripcion")});
            }
            pregunta.add(new Object[]{
                rs.getInt("id_pregunta"),
                rs.getInt("id_tipo_pregunta"),
                rs.getString("pregunta"),
                items,
                content,
                rs.getInt("id_lista"),
                null,
                rs.getInt("id_categoria")
            });
            if(items.isEmpty()){
                opciones.add(rs.getInt("id_lista"));
                items.add(new Object[]{0,rs.getInt("id_lista"),""});
            }
        }
        //recuperar todas las preguntas afectantes
        List<Object[]> relacion_l=_JDBC.getResultList(stmt.executeQuery("SELECT * FROM quiz_relacion WHERE id_afectado IN ("+
                XUtil.toString(id_pregunta_l)+")"),true);
        List js=new ArrayList();
        Map relacion_m=new HashMap();

        for(Object[] r:relacion_l){
            List ll=(List)relacion_m.get(r[3]);
            if(ll==null){
                relacion_m.put(r[3],ll=new ArrayList());
            }
            ll.add(r);
        }
        for(Object[] pp:pregunta){
            if(id_pregunta_l.contains(pp[1])){
                 pp[2]="js "+pp[2];
            }
        }
        rs=stmt.executeQuery("SELECT id_lista,id_opcion,opcion FROM quiz_opcion_lista WHERE id_lista IN ("+XUtil.toString(opciones)+")");
        opciones.clear();
        Object id=false;
        ArrayList opc=null;
        while(rs.next()){
            if(!id.equals(rs.getInt("id_lista"))){
                opciones.add(new Object[]{id=rs.getInt("id_lista"),opc=new ArrayList()});
            }
            opc.add(new Object[]{rs.getString("id_opcion"),rs.getString("opcion")});
        }
        List categoria=new ArrayList();
        XMap m=new XMap();
        for(Object[] p:pregunta){
            if(!m.containsKey(p[7])){
                m.put(p[7],new ArrayList());
                categoria.add(p[7]);
            }
            ((ArrayList)m.get(p[7])).add(p);
        }
        ResultSet rs2=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_catepre,nombre "
                + " FROM quiz_categoria_pregunta WHERE id_catepre IN ("+XUtil.implode(categoria)+") "
                + " OR id_cuestionario="+id_cuestionario
                + " ORDER BY numero,id_catepre");
        categoria.clear();
        if(m.containsKey(0))categoria.add(new Object[]{0,"NINGUNA",m.get(0)});
        while(rs2.next()){
            categoria.add(new Object[]{rs2.getInt(1),rs2.getString(2),m.get(rs2.getInt(1))});
        }
        XMap data=new XMap("questions",categoria,"options",opciones);
        if(asignaturas.size()>0)data.put("cursos",asignaturas);
        request.setAttribute("body","<style>"
                  + ".i-lock{background-image:url("+X.url("images/lock.png")+") !important;}"
            + ".x-fieldset-header-text-collapsible{width:100%;font-size:13px}"
            + ".x-fieldset-header-text{width:100%;font-size:13px}"
            + ".x-tool-default{position:absolute}"
            + "</style>"
            + controls
            + "<div id='form"+embed+"'></div><script>_.x(function(){"
                + "var m=new Ext.menu.Menu({items:["
                    + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                    + "_.o({animateTarget:b,url:'"+X.url("admin/oceca/cuestionario/"+id_cuestionario)+"/'+m.data+'/edit'})"
                    + "}},"
                    + "{text:'Eliminar',iconCls:'i-delete',handler:function(b){"
    //                + "_.o({animateTarget:b,url:'"+JSCore.url("listUsuario/oceca/cuestionario/"+id_cuestionario)+"/'m.data.id_pregunta+'/delete'});"
                    + "}}"
                + "]});"
                + "var mc=new Ext.menu.Menu({items:["
                    + "{text:'Agregar pregunta',iconCls:'i-add',handler:function(b){"
                    + "_.o({animateTarget:b,url:'"+X.url("admin/oceca/cuestionario/"+id_cuestionario)+"/categoria/'+mc.data+'/add'})"
                    + "}},"
                + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                    + "_.o({animateTarget:b,url:'"+X.url("admin/oceca/cuestionario/"+id_cuestionario)+"/categoria/'+mc.data+'/edit'})"
                    + "}},"
                + "{text:'Eliminar',iconCls:'i-delete',handler:function(b){"
                    + "_.o({animateTarget:b,url:'"+X.url("admin/oceca/cuestionario/"+id_cuestionario)+"/categoria/'+mc.data+'/delete'});"
                    + "}}"
                + "]});"
                + "_.create('_.form.QuizPanel',{"
                    + "relation:"+JServlet.toJson(relacion_l)+","
                    + "menuPregunta:m,"
                    + "menuCategoria:mc,"
                    + "data:"+JServlet.toJson(data)+","
                    + "mode:"+(XUtil.isEmpty(roles)&&preview?1:0)+","
                    + "url:'"+X.url(request)+"'"
                + "});"
            + "})</script>");
    }

    private void formCategoria(HttpServletRequest request, HttpServletResponse response,Object id_categoria) throws Exception {
        QuizCategoriaPregunta quizCategoria=JPA.getInstance().get(QuizCategoriaPregunta.class,id_categoria);
        if("update".equalsIgnoreCase(request.getParameter("action"))){
            EntityManager jpa=JPA.getInstance().getEntityManager();
            EntityTransaction t=JPA.getInstance().getTransaction(this);
            try{
                X.copy(request,quizCategoria);
                if(quizCategoria.getIdCategoria()==null){
                    jpa.persist(quizCategoria);
                } else
                    jpa.merge(quizCategoria);
                router.commit(request,response,t);
                return;
            }catch(Exception e){
                JPA.getInstance().rollback(this,e);
            }
        }
        if(quizCategoria.getIdCategoria()!=null)request.setAttribute("title",quizCategoria.getNombre());
        Object id_cuestionario=request.getAttribute("id_cuestionario");
        Object embed=X.toText(request.getAttribute("#embed"));
        request.setAttribute("body","<div id='form"+embed+"'></div><script>_.x(function(){"
            + "_.w('jsform',{standardSubmit:true,mode:1,"
            + "items:["
                + "{xtype:'jstextfield',name:'nombre',value:'"+JServlet.toJS(quizCategoria.getNombre())+"'},"
                + "{xtype:'jsfieldcontainer',items:["
                    + (id_cuestionario instanceof Tag?"{xtype:'displayfield',id:'id_cuestionario"+embed+"',submitValue:1,fieldStyle:'margin-bottom:3px',getSubmitValue:function(){"
                        + "return "+((Tag)id_cuestionario).getId()+"},name:'id_cuestionario',value:'"+JServlet.toJS(id_cuestionario)+"'},":
                        "{xtype:'combobox',name:'id_cuestionario',value:''},"
                        )
                    + "{xtype:'numberfield',flex:0,name:'numero',id:'numero"+embed+"',"
                    + "fieldLabel:'Peso',value:"+quizCategoria.getNumero()+"}"
                + "]},"
                + "{xtype:'textarea',name:'descripcion',value:'"+JServlet.toJS(quizCategoria.getDescripcion())+"'}"
            + "],"
            + "buttons:["
                + "{xtype:'jssave'},"
                + (quizCategoria.getIdCategoria()!=null?"{xtype:'jsdelete'}":"")
            + "]"
            + "});"
        + "});</script>");
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String q[]=(String[]) request.getAttribute(X.Q);
        router=(JServlet) request.getAttribute(X.ROUTER);
        router.dispach(request,MENU);
        periodo=getCurrentPeriod(request);
        if("ask".equalsIgnoreCase(q[0])){
            ask(request, response,q.length>1?XUtil.intValue(q[1]):0,(User)request.getSession().getAttribute(X.USER));
        }else if("admin".equalsIgnoreCase(q[0])){
            if(q.length>2&&"cuestionario".equalsIgnoreCase(q[2])){
                int id_cuestionario=0;
                if(q.length>3&&"create".equalsIgnoreCase(q[3])){
                    formCuestionario(request,response,X.NEW);
                }else if(q.length>3&&(id_cuestionario=XUtil.intValue(q[3]))>0){
                    int id_pregunta=0;
                    int id_catepre=0;
                    if(q.length>4&&(id_pregunta=XUtil.intValue(q[4]))>0){
                        formPregunta(request,response,id_pregunta);
                    }else if(q.length>4&&"edit".equals(q[4])){
                        formCuestionario(request,response,id_cuestionario);
                    }else if(q.length>4&&"add".equals(q[4])){
                        if(q.length>5&&"categoria".equals(q[5])){
                            QuizCuestionario quizCuestionario=JPA.getInstance().get(QuizCuestionario.class,id_cuestionario);
                            request.setAttribute("id_cuestionario",new Tag(id_cuestionario,quizCuestionario.getNombre()));
                            formCategoria(request, response,X.NEW);
                        }else{
                            QuizCuestionario quizCuestionario=JPA.getInstance().get(QuizCuestionario.class,id_cuestionario);
                            request.setAttribute("id_cuestionario",new Tag(id_cuestionario,quizCuestionario.getNombre()));
                            formPregunta(request,response,X.NEW);
                        }
                    }else{
                        viewCuestionario(request,response,id_cuestionario);
                    }
                }else{
                    listCuestionario(request,response);
                }
            }else if(q.length>2&&"encuesta".equals(q[2])){
                int id_encuesta=0;
                if(q.length>3&&"setting".equals(q[3])){
                formSetting(request, response);
                request.setAttribute("title","Opciones de Autoevaluación");
            }else
                if(q.length>4&&"pregunta".equals(q[3])&&XUtil.intValue(q[4])>0){
                    if(q.length>5)request.setAttribute("q5",q[5]);else request.removeAttribute("q5");
                        try{
                        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery(JServlet.print("select id_encuesta "
                                + "FROM sva_encuesta_especialidad "
                                + "WHERE id_especialidad="+XUtil.intValue(request.getAttribute("id_especialidad"))+" "
                                + "and id_cuestionario=1 "
                                + "and id_acper="+XUtil.intValue(request.getAttribute("id_acper"))).toString());
                        if(rs.next())
                            viewPregunta(request, response,XUtil.intValue(q[4]),rs.getInt("id_encuesta"));
                        else
                            throw JServlet.PageNoFoundException;
                    }catch(Exception e){e.printStackTrace();
                    }
                }else if(q.length>3&&"create".equals(q[3])){
                    formEncuesta(request,response,X.NEW);
                }else if(q.length>3&&(id_encuesta=XUtil.intValue(q[3]))>0){
                    int id_pregunta=0;
                    if(q.length>5&&"pregunta".equals(q[4])&&(id_pregunta=XUtil.intValue(q[5]))>0){
                        getEncuestaTitle(request,response,id_encuesta);
                        request.setAttribute("id_encuesta",id_encuesta);
                        ResultSet rs=(ResultSet) request.getAttribute("encuesta");
                        request.setAttribute("id_especialidad",new Tag(rs.getObject("id_especialidad"),rs.getObject("especialidad")));
                        request.setAttribute("id_acper",new Tag(rs.getObject("id_acper"),rs.getObject("cod_acper")));
                        viewPregunta(request,response,id_pregunta);
                    }else if(q.length>4&&"edit".equals(q[4])){
                        formEncuesta(request, response, id_encuesta);
                    }else if(q.length>4&&"participacion".equals(q[4])){
                        int id_participacion=0;
                        if(q.length>5&&(id_participacion=XUtil.intValue(q[5]))>0){
                            if(q.length>6&&("delete".equals(q[6])||"open".equals(q[6])||"reset".equals(q[6]))){
                                request.setAttribute("action",q[6]);
                                formParticipacion(request,response,id_participacion);
                            }else if(q.length>6&&("edit".equals(q[6]))){
                                formParticipacion(request,response,id_participacion);
                            }
                        }else if(q.length>5&&"create".equals(q[5])){
                            formParticipacion(request,response,X.NEW);
                        }else{
                            String t=getEncuestaTitle(request, response, id_encuesta);
                            listParticipacion(request, response, id_encuesta,(User)request.getSession().getAttribute(X.USER));
                            request.setAttribute("title",t);
                        }
                    }else if(q.length>4&&"resultado".equals(q[4])){
                        String t=getEncuestaTitle(request, response, id_encuesta);
                        ResultSet rs=(ResultSet) request.getAttribute("encuesta");
                        if(rs.getInt("id_cuestionario")==4){
                            ((XAction)router.getModule(request,response,"oceda.encuesta")).processRequest(request, response);
                            request.setAttribute("title",t);
                        }
                    }else{
                        String t=getEncuestaTitle(request, response, id_encuesta);
                        viewEncuesta(request, response, id_encuesta);
                        request.setAttribute("title",t);
                    }
                }else{
                    listEncuesta(request, response);
                }
            }else if(q.length>2&&"participacion".equals(q[2])){
                int id_participacion=XUtil.intValue(q[3]);
                ask(request, response,JPA.getInstance().get(SvaEncuestaParticipacion.class,id_participacion).getIdEncuesta(),id_participacion,(User)request.getSession().getAttribute(X.USER));
            }else if(q.length>2&&"pregunta".equals(q[2])){
                int id_pregunta=0;
                if(q.length>2&&"options".equalsIgnoreCase(q[2])){
                    request.setAttribute("body","<div id='grid'></div>"
                    + "<script>_.x(function(){"
                    + "_.w('jsform',items:[{xtype:'jsgrid',paging:false,columns:{id_lista:false,lista:{flex:1}},clazz:'"+qQuizOptionList.getClass().getCanonicalName()+"',renderTo:'list',data:"+X.gson.toJson(_JDBC.getResultList(request,qQuizOptionList))
                    + ",fields:"+X.gson.toJson(qQuizOptionList.getMetadata())
                    + "},"
                    + "{paging:false,xtype:'jsgrid',columns:{},clazz:'"+qQuizOption.getClass().getCanonicalName()+"',renderTo:'options',data:"+X.gson.toJson(_JDBC.getResultList(request,qQuizOption))
                    + ",fields:"+X.gson.toJson(qQuizOption.getMetadata())
                    + "}]);"
                    + "})</script>");
                    request.setAttribute("title","Opciones de pregunta");
                }else if(q.length>2&&"create".equalsIgnoreCase(q[2])){
                    formPregunta(request, response,new SgcFuentePregunta());
                }else if (q.length>2&&(id_pregunta=XUtil.intValue(q[2]))>0){
                    if(q.length>3&&"edit".equalsIgnoreCase(q[3])){
                        formPregunta(request,response,JPA.getInstance().getEntityManager().find(SgcFuentePregunta.class,id_pregunta));
                    }else if(q.length>3&&"delete".equalsIgnoreCase(q[3])){
                        formPregunta(request,response,JPA.getInstance().getEntityManager().find(SgcFuentePregunta.class,id_pregunta));
                    }else{
                        viewPregunta(request,response,id_pregunta,null);
                    }
                }else{
                    listPregunta(request,response);
                }
            }
        }
    }
 
    public static Object getMethod(String m){
        return m;
    }

    private qRespuestaPregunta qRespuestaPregunta=new qRespuestaPregunta();

    private qPreguntaParticipacion qPreguntaParticipacion=new qPreguntaParticipacion();

    public void viewPregunta(HttpServletRequest request, HttpServletResponse response,Object id_pregunta,Object id_encuesta) throws Exception{
        User user=(User) request.getSession().getAttribute(X.USER);
        Object id_acper=XUtil.isEmpty(request.getParameter("id_acper"),periodo!=null?id_acper=periodo.getId():null);
        Object id_especialidad=XUtil.isEmpty(request.getParameter("id_especialidad"),request.getAttribute("id_especialidad"));
        Object action=XUtil.isEmpty(request.getParameter("action"),request.getAttribute("action"));
        Object div=request.getParameter("div");
        Object embed=X.toText(request.getAttribute("#embed"));
        String body="";
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT "
            + "quiz_pregunta.numero,"
            + "quiz_pregunta.pregunta,"
            + "quiz_fuente_pregunta.*,"
            + "quiz_pregunta.id_tipo_pregunta "
            + "FROM quiz_pregunta "
            + "LEFT OUTER JOIN quiz_fuente_pregunta ON quiz_pregunta.id_pregunta=quiz_fuente_pregunta.id_pregunta "
            + "WHERE quiz_pregunta.id_pregunta="+id_pregunta);
        if(rs.next()){
            if(!"div".equals(action)){
                int n=0;
                ResultSet rs2=_JDBC.getCnx(request).createStatement().
                        executeQuery(_JDBC.sql("SELECT id_tipart,tipo_participante "
                        + "FROM sva_tipo_participante WHERE '"+rs.getString("flags")+"' LIKE string('%',id_tipart,'%')"));
                String typeItems="";
                while(rs2.next()){
                    n++;
                    typeItems+="{boxLabel:'"+rs2.getObject(2)+"',inputValue:'"+rs2.getObject(1)+"',checked:true},";
                }
                body+="<div id='form"+embed+"'></div><script>_.x(function(){"
                        + "_.w('jsfilter',{"
                            + (action!=null?"buttons:0,":"")
                            + "items:["
                                + "{xtype:'jshidden',name:'embed',value:'"+embed+"'},"
                                + "{xtype:'jshidden',name:'action',value:'div'}"
        //                      + ","+ ((JSAction)router.getModule("oceda", request, response)).getComponent(request,response,user)
                                + (typeItems.length()>0?",{xtype:'fieldset',title:'Tipo participante',items:{xtype:'checkboxgroup',name:'rol',columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
                                + typeItems
                                + "]}}":"")
                            + "],"
                            + "target:_.g('result"+embed+"')"
                        + "}).updateLayout();"
                    + "})</script>"
                    + "<div id=result"+embed+"></div>";
                request.setAttribute("title",rs.getString("pregunta"));
            }
            X.log("export.equals(action) action="+action);
            if(action!=null){
                try{
                    request.setAttribute("#all",true);
                    List<Object[]> data=null;
                    int id_tipo_pregunta=rs.getInt("id_tipo_pregunta");
                    Map map=(Map)XUtil.isEmpty(request.getAttribute(X.PARAMS),new HashMap());
                    map.put("id_acper",id_acper);
                    map.put("id_encuesta",id_encuesta);
                    map.put("id_pregunta",id_pregunta);
                    request.setAttribute(X.PARAMS,map);
                    if("participacion".equals(request.getAttribute("q5"))){
                        JavaAction.traslate(request);
                        ((Map)XUtil.isEmpty(request.getAttribute(X.FILTERS),new HashMap())).putAll((Map)request.getAttribute(X.PARAMS));
                        data=_JDBC.getResultList(request,qPreguntaParticipacion);
                    }else if(id_tipo_pregunta==2){
                        data=_JDBC.getResultList(request,qRespuestaTexto);
                    }else{
                        JavaAction.traslate(request);
                        ((Map)XUtil.isEmpty(request.getAttribute(X.FILTERS),new HashMap())).putAll((Map)request.getAttribute(X.PARAMS));
                        data=_JDBC.getResultList(request,qRespuestaPregunta);
                    }
                    if("export".equals(action)){
                        if("participacion".equals(request.getAttribute("q5"))){
                            request.setAttribute(X.PARAMS,new XMap(TableModel.class,new SimpleStore(qPreguntaParticipacion,data)));
                            request.setAttribute(Class.class.getCanonicalName(),qPreguntaParticipacion.getClass());
//                            ((JServlet)router.getModule(body, request, response)).processRequest(request, response);
                        }else{
                            request.setAttribute(X.PARAMS,new XMap(TableModel.class,new SimpleStore(qRespuestaPregunta,data)));
                            request.setAttribute(Class.class.getCanonicalName(),qRespuestaPregunta.getClass());
//                            ((JServlet)router.getModule(body, request, response)).processRequest(request, response);
                        }
                        return;
                    }
                    if("view".equals(action)){
                        if("participacion".equals(request.getAttribute("q5"))){
                            map.put(qPreguntaParticipacion.getClass().getSimpleName()+request.getAttribute("id_fuepar"),new SimpleStore(qPreguntaParticipacion,data));
                            request.setAttribute(X.PARAMS,map);
                            body="org/jsuns/sgc/encuesta/qPreguntaParticipacion.jasper";
                        }else{
                            map.put(qRespuestaPregunta.getClass().getSimpleName()+request.getAttribute("id_fuepar"),new SimpleStore(qRespuestaPregunta,data));
                            request.setAttribute(X.PARAMS,map);
                            body="org/jsuns/sgc/encuesta/qRespuestaPregunta.jasper";
                        }
                    }else if(data.size()>0){
                        if(id_tipo_pregunta==2){
                            body+="<script>_.x(function(){"
                                + "var store=JSCore.s({fields:"+X.gson.toJson(qRespuestaTexto.getMetadata())+",data:"+X.gson.toJson(data)+"});"
                                + "_.w('jsgrid',{"
                                        + "renderTo:'result"+embed+"',"
                                        + "fields:"+X.gson.toJson(qRespuestaTexto.getMetadata())+",viewConfig:{markDirty:false},"
                                        + "paging:false,width:500,store:store,"
                                        + "columns:["
                                            + "{dataIndex:'respuesta',flex:1,width:100}"
                                        + "]"
                                    + "});"
                                + "});</script>";
                        }else{
                            body+="<script>_.x(function(){"
                                + "var store=JSCore.s({fields:"+X.gson.toJson(qRespuestaPregunta.getMetadata())+",data:"+X.gson.toJson(data)+"});"
                                + "_.w('jsgrid',{"
                                    + "renderTo:'result"+embed+"',"
                                    + "fields:"+X.gson.toJson(qRespuestaPregunta.getMetadata())+",viewConfig:{markDirty:false},"
                                    + "paging:false,width:500,store:store,"
                                    + "columns:["
                                        + "{dataIndex:'opcion',flex:1},"
                                        + "{dataIndex:'porcentaje',width:100,align:'right'},"
                                        + "{dataIndex:'votos',h:{width:100,text:'Votos',align:'right'},xtype:'menucolumn',bValue:function(o,m,r,b){"
                                        + "return Ext.merge(b,{iconCls:'',handler:function(b){"
                                        + "if(b.data.votos)"
                                        + "_.o({url:'"+X.url("admin/oceca/encuesta/")+id_encuesta+"/pregunta/"+id_pregunta+"/opcion/'+b.data.id_opcion});"
                                        + "},text:r.data.votos?r.data.votos:'0'})}}"
                                    + "]"
                                + "});"
                                + "_.w('panel',{"
                                    + "bodyStyle:'border-width:0;background:transparent;',"
                                    + "renderTo:'result"+embed+"',height:500,layout:'fit',"
                                    + "items:["
                                    + "Ext.create('Ext.chart.Chart',{xtype:'chart',"
                                    + "animate:true,"
                                    + "store:store,"
                                    + "legend:{position: 'right'},insetPadding:40,"
                                    + "series:[{type:'pie',field:'votos',showInLegend:false,"
                                    + "label:{renderer:function(v){"
                                        + "v=store.findRecord('id_opcion',v);"
                                        + "return (v.get('votos')>0?v.get('opcion')+'\\n'+v.get('porcentaje')+'%':'')"
                                    + "},field:'id_opcion',display: 'middle',contrast: true,font: '14px Arial'"
                                    + "}}]})]"
                                + "});"
                                + "});"
                                + "</script>";
                        }
                    }else{
                        body+= "<b>No hay datos registrados.</b>";
                    }
                    if(!"view".equals(action)){
                        router.die(request, response,body);
                        return;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            request.setAttribute("body",body);
        }else
            throw JServlet.PageNoFoundException;
    }

    private qRespuestaTexto qRespuestaTexto =new qRespuestaTexto();
    public static final int ENCUESTA=1;
    public static final int ENTREVISTA=2;
    public static final int CUESTIONARIO=3;
    public static final int EVALUACION_DOCENTE=4;

    public void formPregunta(HttpServletRequest request, HttpServletResponse response,Object id_pregunta) throws ServletException,Exception{
        EntityManager jpa=JPA.getInstance().getEntityManager();
        QuizPregunta quizPregunta=JPA.getInstance().get(QuizPregunta.class,id_pregunta);
        Node node = null;
        SgcFuentePregunta sgcFuentePregunta;
        if(quizPregunta.getIdPregunta()!=null){
            sgcFuentePregunta=jpa.find(SgcFuentePregunta.class,quizPregunta.getIdPregunta());
            if(sgcFuentePregunta!=null){
                //Esta mal id_fuente no tiene relacion a los nodos
                //node=jpa.find(Node.class,sgcFuentePregunta.getIdFuente());
            }else{
                sgcFuentePregunta=new SgcFuentePregunta();
                //node=new Node();
            }
            node=new Node();
        }else{
            sgcFuentePregunta=new SgcFuentePregunta();
            node=new Node();
        }
        if("update".equalsIgnoreCase(request.getParameter("action"))){
            EntityTransaction t=JPA.getInstance().getTransaction(request);
            try{
                String rol[]=request.getParameterValues("rol");
                sgcFuentePregunta.setFlag(XUtil.implode((rol!=null?Arrays.asList(rol):Collections.EMPTY_LIST).toArray(),""));
                sgcFuentePregunta.setEstado(true);
                X.copy(request,quizPregunta);
                node.setTitle(quizPregunta.getPregunta());
                if(quizPregunta.getIdPregunta()==null){
                    jpa.persist(quizPregunta);
                }else{
                    jpa.merge(quizPregunta);
                }
                String data=request.getParameter("id_afectante");
                if(data!=null){
                    JsonElement params=new JsonParser().parse(data);
                    JsonArray record=(params instanceof JsonArray)?record=(JsonArray)params:null;
                    if(record!=null){
                        for(JsonElement ee:record){
                            JsonObject o=(JsonObject) ee;
                            switch(o.get("x").getAsInt()){
                                case 1:
                                    o=o.get("changes").getAsJsonObject();
                                    if(!(o.has("delete")&&o.get("delete").getAsBoolean())){
                                        QuizRelacion quizRelacion=new QuizRelacion();
                                        X.write(o,quizRelacion);
                                        quizRelacion.setIdAfectado(quizPregunta.getIdPregunta());
                                        jpa.persist(quizRelacion);
                                    }
                                    break;
                                case 0:
                                    JsonObject changes=o.get("changes").getAsJsonObject();
                                    o=o.get("key").getAsJsonObject();
                                    if(changes.has("delete")&&changes.get("delete").getAsBoolean()){
                                        jpa.remove(jpa.find(QuizRelacion.class,o.get("id_relacion").getAsInt()));
                                    }else{
                                        jpa.persist(X.gson.fromJson(changes,QuizRelacion.class));
                                    }
                            }
                        }
                    }
                }
                if(sgcFuentePregunta.getIdPregunta()==null){
                    sgcFuentePregunta.setIdPregunta(quizPregunta.getIdPregunta());
                    jpa.persist(sgcFuentePregunta);
                }else{
                    sgcFuentePregunta.setIdPregunta(quizPregunta.getIdPregunta());
                    jpa.merge(sgcFuentePregunta);
                }
                router.commit(request,response,t,false);
                return;
            }catch(Exception e){
                JPA.getInstance().rollback(this);
                X.alert(e);
            }
        }
        Map form=new XMap("#node",node);
        request.setAttribute(SgcFuente.class.getCanonicalName(),jpa.find(SgcFuente.class,sgcFuentePregunta.getIdFuente()));
        String typeItems=" ";
        int n=0;
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_tipo,tipo_participante FROM sva_tipo_participante ORDER BY base DESC,tipo_participante");
        while(rs.next()){
            typeItems+="{boxLabel:'"+rs.getObject(2)+"',inputValue:'"+rs.getObject(1)+"'"+(",checked:"+XUtil.booleanValue(sgcFuentePregunta.getFlag().contains(rs.getString("id_tipo"))))+"},";
            n++;
        }
        if(n>0)typeItems=typeItems.substring(0,typeItems.length()-1);
        if(quizPregunta.getIdPregunta()!=null)request.setAttribute("title",quizPregunta.getPregunta());
        Object id_cuestionario=request.getAttribute("id_cuestionario");
        if(id_cuestionario!=null)quizPregunta.setIdCuestionario(XUtil.intValue(id_cuestionario instanceof Tag?((Tag)id_cuestionario).getId():id_cuestionario));
        Object id_catepre=request.getAttribute("id_catepre");
        if(id_catepre!=null)quizPregunta.setIdCategoria(XUtil.intValue(id_catepre));
        form.put("nid",new XMap("#type","hidden","#body","value:"+node.getNid()));
        form.put("title",new XMap("#type","hidden","#body","value:'"+X.toText(node.getTitle())+"'"));
        form.put("id_pregunta",new XMap("#type","hidden","#body","value:"+sgcFuentePregunta.getIdPregunta()));
        form.put("pregunta",new XMap("#weight",0,"#type","textarea","#body","height:70,value:'"+JServlet.toJS(quizPregunta.getPregunta())+"'"));
        form.put("id_cuestionario",new XMap("#weight",4,"#type",id_cuestionario instanceof Tag?"displayfield":"jscombobox",
                "#body",id_cuestionario instanceof Tag?"submitValue:1,fieldStyle:'margin-bottom:3px',getSubmitValue:function(){return "+((Tag)id_cuestionario).getId()+"},value:'"+JServlet.toJS(id_cuestionario)+"'":
                "editable:false,value:"+quizPregunta.getIdCuestionario()+
                ",store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_cuestionario,nombre from quiz_cuestionario").getResultList())+",fields: ['v','d']})"));
        form.put("id_categoria",new XMap("#weight",8,"#type","jscombobox","#body","editable:false,value:"+quizPregunta.getIdCategoria()+","
                + "store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_catepre,nombre from quiz_categoria_pregunta "
                + "WHERE id_cuestionario="+quizPregunta.getIdCuestionario()).getResultList())+",fields: ['v','d']})"));
        form.put("set1",new XMap("#weight",12,"#type","jsfieldcontainer","#body","items:["
                + "{xtype:'jsfieldcontainer',fieldLabel:'Opciones',items:["
                    + "{xtype:'jscombobox',fieldLabel:false,name:'id_lista',"
                    + "editable:false,value:"+quizPregunta.getIdLista()+","
                    + "store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_lista,lista from quiz_lista order by lista").getResultList())
                    + ",fields: ['v','d']})},"
                    + "{xtype:'jsbutton',flex:0,iconCls:'i-edit',handler:function(b){"
                    + "_.o({url:'"+X.url("admin/oceca/cuestionario/opcion")+"'});"
                    + "}}"
                + "]},"
                + "{xtype:'jstextfield',value:"+quizPregunta.getIdTipoPregunta()+",name:'id_tipo_pregunta',fieldLabel:'Tipo'},"
                + "{xtype:'numberfield',name:'numero',flex:0,value:"+quizPregunta.getNumero()+",fieldLabel:'Peso'}"
            + "]"));
        if(typeItems.length()>1)
            form.put("tipo_participante",new XMap("#weight",16,"#type","checkboxgroup","#body","style:'margin-top:7px',fieldLabel:'Tipo participante',height:"+((25*(int)Math.ceil((1.0*n)/2))+10)+",columns:2,defaults:{fieldLabel:false,name:'rol'},items:["+ typeItems+ "]"));
        request.setAttribute(X.FILTERS,new XMap("id_afectado",quizPregunta.getIdPregunta()));
        request.removeAttribute("#meta");
        form.put("afectantes",new XMap("#weight",20,"#type","fieldset","#body","title:'Afectantes',items:{xtype:'jsform',items:["
                + "{xtype:'jshidden',name:'id_afectante'},"
                + "{xtype:'jsgrid',editable:true,paging:false,clazz:'"+qAfectante.class.getCanonicalName()+"',"
                + "data:"+X.gson.toJson(_JDBC.getResultList(request,qAfectante))+","
                + "totalCount:"+request.getAttribute(X.COUNT)+","
                + "fields:"+X.gson.toJson(qAfectante.getMetadata())+","
                + "columns:["
                        + "{dataIndex:'pregunta',flex:1,editor:false},"
                        + "{dataIndex:'comparador',align:'center'},"
                        + "{dataIndex:'id_opcion'},"
                        + "{dataIndex:'activo'},"
                        + "{dataIndex:'total'}"
                + "]"
                + "}],buttons:["
                + "{xtype:'jssearch',iconCls:'i-add',flex:0,scfg:{url:'"+X.url("admin/oceca/pregunta")+"',ok:function(s,w,b){"
                    + "var f=b.up('form'),d=s[0].data;"
                    + "var nr={"
                        + "id_afectante:d.id_pregunta,"
                        + "pregunta:d.pregunta,"
                    + "};"
                    + "f.down('grid').getStore().insert(0,nr);"
                + "}}}"
                + "]}"));
        form.put("#body","buttons:["
            + "{xtype:'jssave'}"
            + (sgcFuentePregunta.getIdPregunta()!=null?",{xtype:'jsdelete'}":"")
            + "]");
        request.setAttribute("body",X.getForm(request,form));
    }

    private static String return_encuesta="return-encuesta";

    private static Map quizMap=new XMap(
            1,"Encuesta","encuesta","Encuesta","#encuesta",1,"#1","encuesta",
            2,"Entrevista","entrevista","Entrevista","#entrevista",2,"#2","entrevista",
            3,"Cuestionario","cuestionario","Cuestionario","#cuestionario",3,"#3","cuestionario",
            4,"Evaluación Desempeño Docente","evaluacion-desempeno-docente","Evaluacion Desempeño Docente","#evaluacion-desempeno-docente",4,"#4","evaluacion-desempeno-docente");
    

    public void viewEncuesta(Object id_encuesta) throws ServletException,Exception{
        request.setAttribute("include","<script type='text/javascript' src='"+X.url("ux/jsuns.js")+"'></script>");
        User user=(User)request.getSession().getAttribute(X.USER);
        boolean admin=UserAction.access(request,admin_encuesta,user);
        String[] q=(String[])request.getAttribute(X.Q);
        Object action=request.getParameter("action");
        if("activo".equals(action)){
            EntityManager jpa=JPA.getInstance().getEntityManager();
            SgcEncuestaEspecialidad encuestaEspecialidad=JPA.getInstance().get(SgcEncuestaEspecialidad.class,id_encuesta);
            EntityTransaction t=JPA.getInstance().getTransaction(request);
            try{
                X.copy(request,encuestaEspecialidad);
                if("activo".equals(action)){
                    encuestaEspecialidad.setActivo(!encuestaEspecialidad.getActivo());
                    if(!encuestaEspecialidad.getActivo()){
                        encuestaEspecialidad.setFechaFin(new java.util.Date());
                        encuestaEspecialidad.setEstado('C');
                    }else if(encuestaEspecialidad.getFechaIni()==null&&encuestaEspecialidad.getActivo()){
                        encuestaEspecialidad.setFechaIni(new java.util.Date());
                        encuestaEspecialidad.setEstado('A');
                    }
                }
                jpa.merge(encuestaEspecialidad);
                encuestas=null;
                if("activo".equals(action)){
                    t.commit();
                    router.die(request, response,"{success:true,activo:"+encuestaEspecialidad.getActivo()+"}");
                    return;
                }
            }catch(Exception e){
                JPA.getInstance().rollback(this,e);
            }
        }
        request.setAttribute("title",getEncuestaTitle(request, response, id_encuesta));
        ResultSet rs2=(ResultSet)request.getAttribute("encuesta");
        Object id_cuestionario=rs2.getInt("id_cuestionario");
        String c="";
        List<Object[]> types=getTypes(request,id_encuesta);
        if(types.size()!=1){
            for(Object t[]:types){
                if("adesg".contains(t[0].toString().toLowerCase()))
                c+="{dataIndex:'"+t[0].toString().toLowerCase()+"',xtype:'checkcolumn',text:'"+XUtil.capitalize(t[1].toString().substring(0,3))+"',width:60},";
            }
        }
        String body="<style>"
            + ".i-start{background-image:url("+X.url("images/play.png")+");}"
            + ".i-stop{background-image:url("+X.url("images/pause.png")+");}"
            + "</style>";
        Q jquery=qPreguntasFuenteVigente_X_Encuesta;
        int id_especialidad=rs2.getInt("id_especialidad");
        boolean activo=rs2.getBoolean("activo");
        request.setAttribute(X.PARAMS,new XMap(
            "id_cuestionario",id_cuestionario,
            "id_encuesta",id_encuesta,
            "id_especialidad",id_especialidad
        ));

        String typeItems=" ";
        int n=0;
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_tipo,tipo_participante FROM sva_tipo_participante ORDER BY base DESC,tipo_participante");
        while(rs.next()){
            typeItems+="{boxLabel:'"+rs.getObject(2)+"',inputValue:'"+rs.getObject(1)+"'},";
            n++;
        }
        if(n>0)typeItems=typeItems.substring(0,typeItems.length()-1);
        if("export".equals(action)){
            JavaAction.traslate(request);
            XMap params=new XMap();
            request.setAttribute("#all",true);
            params.put("preguntas",new SimpleStore(jquery,_JDBC.getResultList(request,jquery)));
            JavaAction.traslate(request);
            ((XMap)XUtil.isEmpty(request.getAttribute(X.FILTERS),new XMap())).putAll((XMap)request.getAttribute(X.PARAMS));
            params.put("respuestas",new SimpleStore(qRespuestaPreguntasEspecialidad,_JDBC.getResultList(request,qRespuestaPreguntasEspecialidad))
            );
            request.setAttribute(X.PARAMS,params);
//            JReportAction.export(request, response, user,"/org/jsuns/oceca/sgc/qInforme.jasper");
            return;
        }
        EntityManager jpa=JPA.getInstance().getEntityManager();
        id_encuesta=XUtil.intValue(id_encuesta)==X.NEW?null:id_encuesta;
        Object embed=X.toText(request.getAttribute("#embed"));
        body+="<div id='form"+embed+"'></div><div id='grid"+embed+"'></div><script>_.x(function(){"

            + "var f=JSCore.w('jsfilter',{"
            + "standardSubmit:"+(id_encuesta==null)+","
            + "buttonAlign:'right',padding:'0 0 20 0',"
            //+ "url:'"+JSCore.url("sva/encuesta/"+id_encuesta+"/")+"/',"
            + "items:["
            + ((id_encuesta==null)?"{xtype:'jsfieldcontainer',items:["
            + ((XAction)router.getModule(request,"oceda")).getComponent(request, response, user)
            + "]},"
            : "{xtype:'hidden',name:'id_especialidad',value:"+id_especialidad+"},")
            + ((id_encuesta==null)?"{xtype:'jsfieldcontainer',items:[{xtype:'jscombobox',allowBlank:false,fieldLabel:'Modelo',name:'id_modelo',"
            + "listeners:{"
            + "},"
            + "store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_modelo,modelo from sgc_modelo order by modelo").getResultList())
            + ",fields:['v','d']})},"
            + "{xtype:'checkbox',name:'activo',boxLabel:'Formato disponible'}]},":
            "{xtype:'jsfieldcontainer',items:["
                + "{xtype:'jscombobox',name:'id_categoria',"
                + "store:new Ext.data.ArrayStore({data:"+X.gson.toJson(jpa.createNativeQuery("SELECT id_catepre,nombre from quiz_categoria_pregunta "
                + "WHERE id_cuestionario="+id_cuestionario+" ORDER BY nombre ").getResultList())+",fields: ['v','d']})},"
                + "{xtype:'jstextfield',name:'pregunta'}"
            + "]}"
            + ",")
        + "{xtype:'hidden',name:'id_encuesta',value:"+id_encuesta+"}"
           + (typeItems.length()>0?",{xtype:'fieldset',title:'Tipo participante',items:{xtype:'checkboxgroup',name:'rol',columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
                            + typeItems
                            + "]}}":"")

                + "],buttons:["
        + (admin?"{xtype:'jssave'}"
        + (id_encuesta!=null?","
        + "{xtype:'jsbutton',handler:function(b){"
            + "b.up('form').save({"
                + "params:{action:'active'},"
                + "ok:function(f,a){"
                    + "var activo=a.result.activo;"
                    + "b.setIconCls(activo?'i-stop':'i-start');"
                    + "b.setText(activo?'Desactivar':'Activar');"
                + "}"
            + "});"
        + "},"
        + "text:'"+(activo?"Desactivar":"Activar")+"',"
        + "iconCls:'"+(activo?"i-stop":"i-start")+"'},'->'":"")
        :"")
        + "],"
        + "target:_.w('jsgrid',{"
        + "clazz:'"+jquery.getClass().getCanonicalName()+"',"
        + "data:"+X.gson.toJson(_JDBC.getResultList(request,jquery))+","
        + "totalCount:"+request.getAttribute(X.COUNT)+","
        + "fields:"+X.gson.toJson(jquery.getMetadata())+","
        + "getFilters:function(){return f;},getParameters:function(){return {"
        + "id_encuesta:"+id_encuesta+"}}"
        + ",groupField:'id_categoria',"
        + "features:["
        + "{"
        + "id:'group',"
        + "ftype:'groupingsummary',"
        + "groupField:'id_categoria',"
        + "groupHeaderTpl:'{[values.rows[0].data.nombre?values.rows[0].data.nombre:\"NO CATEGORIZADO\"]}',"
        + "hideGroupedHeader: true"
        + "}"
        + "]"
        + ",columns:["
        + (admin?"{xtype:'menucolumn',popup:function(){"
                + "var m=new Ext.menu.Menu({items:["
                    + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                    + "_.o({url:'"+X.url("admin/oceca/cuestionario/"+id_cuestionario)+"/'+m.data.id_pregunta+'/edit'})"
                    + "}},"
                    + "{text:'Delete',iconCls:'i-delete',handler:function(b){"
                    + "_.call({url:'"+X.url("admin/oceca/"+id_cuestionario)+"/'+m.data.id_pregunta+'/delete'});"
                    + "}}"
                    + "]});"
                    + "return m;"
                + "}},":"")

        + "{dataIndex:'pregunta',flex:1,tdValue:function(v,m,r){return '<a onclick=\"return _.o(this);\" href=\""+X.url("admin/oceca/encuesta/"+id_encuesta+"/pregunta")+"/'+r.data.id_pregunta+'\">'+v+'</a>'}},"
        + c
        + "{dataIndex:'estado',xtype:'checkcolumn',text:'Estado',width:60}"
        + "]"
        + "})});"
        + "})</script>";
        request.setAttribute("body", body);
    }

    public void listParticipacion(Object id_encuesta,User user) throws Exception{
        ResultSet rs=(ResultSet) request.getAttribute("encuesta");
        boolean admin=UserAction.access(request,SGCAction.admin_sgc,user);
        Map map=_JDBC.toMap(rs);
        for(Object key:map.keySet())request.setAttribute(key.toString(),map.get(key));
        
        if(XUtil.intValue(map.get("id_cuestionario"))==4){
            Object form=router.getModule(request,"oceda.encuesta");
            form.getClass().getMethod("listParticipacion",HttpServletRequest.class,HttpServletResponse.class,Object.class,User.class).invoke(form,request,response,id_encuesta,user);
        }else{
            Object embed=X.toText(request.getAttribute("#embed"));
            String body="<STYLE>.i-start{background-image:url("+X.url("images/play.png")+") !important;}</STYLE>"
                    + "<div id='form"+embed+"'></div></div><div id='grid"+embed+"'></div>";
            request.setAttribute(X.PARAMS,new XMap("id_tipo",1,"nombre_completo",""));
            request.setAttribute("#meta",true);
            body+="<script>_.x(function(){"
                + "var g;";

            request.setAttribute(X.FILTERS,new XMap("id_encuesta",id_encuesta));
            request.removeAttribute("#meta");
            String typeItems=" ";
            int n=0;
            rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_tipo,tipo_participante FROM sva_tipo_participante ORDER BY base DESC,tipo_participante");
            while(rs.next()){
                typeItems+="{boxLabel:'"+rs.getObject(2)+"',inputValue:'"+rs.getObject(1)+"'},";
                n++;
            }
            if(n>0)typeItems=typeItems.substring(0,typeItems.length()-1);

            body+="var f=JSCore.w('jsfilter',{"
                + "items:["
                    + "{xtype:'jsfieldcontainer',items:["
                    + ((XAction)router.getModule(request,"oceda")).getComponent(request, response,user)
                    + "]},"
                    + "{xtype:'hidden',name:'id_encuesta',value:"+id_encuesta+"},"
                    + "{xtype:'jsfieldcontainer',items:["
                    + "{xtype:'jstextfield',name:'nombre_completo'},"
                    + "{xtype:'jscombobox',flex:0,fieldLabel:'Estado',name:'cerrado',store:new Ext.data.ArrayStore({data:["
                    + "[1,'CERRADO'],"
                    + "[0,'ABIERTO']"
                    + "],fields:['v','d']})}"
                    + "]}"
                    + (typeItems.length()>1?",{xtype:'checkboxgroup',style:'margin-top:7px',name:'rol',fieldLabel:'Tipo de Participante',height:"+(26*(int)Math.ceil(n/2.0))+",columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
                    + typeItems
                    + "]}":"")
                + "],"
                + "target:g=JSCore.w('jsgrid',{clazz:'"+qEncuestaParticipacion.getClass().getCanonicalName()+"',"
                + "data:"+X.gson.toJson(_JDBC.getResultList(request,qEncuestaParticipacion))+",fields:"+X.gson.toJson(qEncuestaParticipacion.getMetadata())+","
                + "totalCount:"+request.getAttribute(X.COUNT)
                + ",getFilters:function(){return f}"
                + ",columns:["
                + (admin?"{xtype:'menucolumn',popup:function(){"
                        + "var m=new Ext.menu.Menu({items:["
                        + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                        + "_.o({url:'"+X.url("admin/oceca/encuesta/"+id_encuesta+"/participacion/")+"'+m.data.id_participacion+'/edit'});"
                        + "}},"
                        + "{text:'Eliminar',iconCls:'i-delete',handler:function(b){"
                        + "_.call({"
                        + "url:'"+X.url("admin/oceca/encuesta/"+id_encuesta+"/participacion/")+"'+m.data.id_participacion+'/delete'"
                        + ",success:function(response,opts){g.load();}"
                        + "});"
                        + "}},"
                        + "{text:'Reactivar',iconCls:'i-start',handler:function(b){"
                        + "_.call({url:'"+X.url("admin/oceca/encuesta/"+id_encuesta+"/participacion/")+"'+m.data.id_participacion+'/open'"
                        + ",success:function(response,opts){g.load();}"
                        + "});"
                        + "}},"
                        + "{text:'Reiniciar',iconCls:'i-new',handler:function(b){"
                        + "_.call({url:'"+X.url("admin/oceca/encuesta/"+id_encuesta+"/participacion/")+"'+m.data.id_participacion+'/reset'"
                        + ",success:function(response,opts){g.load();}"
                        + "});"
                        + "}}"
                    + "],listeners:{'beforeshow':function(m){"
                        + "m.items.getAt(2).setVisible(m.data.cerrado);"
                    + "}}});"
                    + "return m;"
                + "}},":"")
                + "{dataIndex:'nombre_completo',"
                + "tdStyle:function(v,m,o){if(!o.data.nombre_completo)return 'background-color:#FAB1C2'; if(!o.data.cerrado) return 'background-color:#BBFFAA'; },"
                + "tdValue:function(v,m,o){return v?'<a onclick=\"return _.o(this)\" href=\""+X.url("admin/ocid/directorio/")+"'+o.data.id_dir+'\">'+v+'</a>':'INDEFINIDO'},"
                + "text:'Participante',flex:1},"
                + "{dataIndex:'especialidad',flex:1},"
                + "{dataIndex:'flags',width:50},"
                + "{dataIndex:'fecha_ini'},"
                + "{dataIndex:'fecha_fin'},"
                + "{dataIndex:'id_participacion',xtype:'menucolumn',bValue:function(v,m,r,b){b.handler=function(b){"
                + "_.o({animateTarget:b,url:'"+X.url("admin/sva/participacion/")+"'+v});"
                + "};b.iconCls='i-preview'}}"
                + "]"
                + "}),"
                + (admin?"buttons:["
                + "{xtype:'jssearch',iconCls:'i-add',text:'Añadir participante',flex:0,scfg:{url:'"+X.url("admin/ocid/directorio")+"',ok:function(s,w,b){"
                    + "var d=s[0].data;"
                    + "var f=b.up('form').save({"
                        + "url:'"+X.url("admin/oceca/encuesta/"+id_encuesta+"/participacion/create")+"',"
                        + "params:{id_dir:d.id_dir,action:'update'},"
                        + "ok:function(f,a){g.load();}"
                    + "});"
                + "}}},"
                + "'->'"
                + "]":"")
                + "});"

                + "})</script>";
            request.setAttribute("body", body);
        }
    }

    public void ask(int id_encuesta,User user) throws Exception{
        request.setAttribute("ask",true);
        X.log("user="+user+" id_encuesta="+id_encuesta);
        if(user.getUid()==0)throw JServlet.PageNoFoundException;

        
        if(id_encuesta>0)
            request.setAttribute("title",this.getEncuestaTitle(request, response, id_encuesta));
        else if(request.getAttribute("ask")!=null)
            request.setAttribute("title","Entrada de participante");
        ask(request, response, id_encuesta,0,user);
    }

    private static List tipoParticipante=null;

    public Map menu(HttpServletRequest request,HttpServletResponse responsel,Map menu){
        menu.put("admin/oceca/encuesta",new XMap(
            "title","Encuestas",
            "description","Cambiar información basica del sitio, como es el nombre del sitio, lema, dirección de correo, mision, pagina de portada y mas.",
            "page callback","listEncuesta"
        ));
        return menu;
    }

    public void ask(HttpServletRequest request, HttpServletResponse response,int id_encuesta,Object id_participacion,User user) throws Exception{
        int id_cuestionario=0;
        Map<Object,List<Character>> rolMap=getRoles(request,response,user);
        List<Object[]> participaciones=(List)request.getSession().getAttribute("#participacion");
        X.log("rolMap="+X.gson.toJson(rolMap));
        if(id_encuesta==0){
            if(participaciones!=null&&participaciones.size()>0){
                List rolList=new ArrayList();
                for(List li:rolMap.values())for(Object id:li)if(!rolList.contains(id))rolList.add(id);
//                JSCore.alert(request,JSCore.gson.toJson(encuestas));
//                X.log(X.gson.toJson(encuestas));
                String body="<div class='form-item'><label>Periodo Actual:</label>"+periodo+"</div>";
                if(rolList.size()>0){
                    ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT * FROM sva_tipo_participante WHERE id_tipo IN ('"+XUtil.implode(rolList,',')+"')");
                    body+="<div class='form-item'><label>Tipo de Participante:</label><ul class=menu>";
                    while(rs.next()){
                        body+="<li>"+rs.getObject("tipo_participante")+"</li>";
                    }
                    body+="</ul></div>";
                }
                List quizList=new ArrayList();
                for(Object[] p:participaciones){
                    quizList.add(new Object[]{
                        p[0],
                        p[1],p[2],p[3],p[4],
                        X.toText(p[5] instanceof Object[]?
                            quizMap.get(id_cuestionario=XUtil.intValue(((Object[])p[5])[2]))
                            +" "+((Object[])p[5])[3]:p[5]
                        ).trim().toUpperCase(),
                        p[6],p[7]});
                }
                if(quizList.size()>0){
                    Object embed=X.toText(request.getAttribute("#embed"));
                    request.setAttribute("#meta",true);
                    body+="<div id='grid"+embed+"'></div>"
                        + "<script>_.x(function(){"
                            + "_.w('fieldset',{"
                                + "renderTo:'grid"+embed+"',title:'Formatos disponibles',items:{xtype:'jsgrid',paging:false,"
                                + "clazz:'"+qEncuestaParticipacion0.class.getCanonicalName()+"',"
                                + "data:"+X.gson.toJson(quizList)+","
                                + "fields:"+X.gson.toJson(_JDBC.getResultList(request,qEncuestaParticipacion0))+",totalCount:"+quizList.size()+","
                                + "columns:["
                                    + "{xtype:'textcolumn',dataIndex:'encuesta',text:'Descripcion',flex:1,align:'left',"
                                    + "tdValue:function(v,m,r){return '<A onclick=\"return _.o(this)\" "
                                    + "href=\""+X.url("ask/")+"'+r.data.id_encuesta+'\">'+v+'</A>'}},"
                                    + "{dataIndex:'fecha_ini'},"
                                    + "{dataIndex:'fecha_fin'},"
                                    + "{dataIndex:'cerrado'}"
                                + "]"
                            + "}})"
                        + "})</script>";
                }
                request.setAttribute("body",body);
            }else{
                X.log("no encontro ninguna");
                throw JServlet.PageNoFoundException;
            }
            return;
        }
        String q[]=(String[])request.getAttribute(X.Q);
        List<Character> roles=null;
        boolean ask=request.getAttribute("ask")!=null;
        boolean preview=!ask&&XUtil.intValue(id_participacion)==0;
        if(preview){
            roles=new ArrayList();
            String rol[]=request.getParameterValues("rol");
            if(rol!=null)
                for(String r:rol){
                    roles.add(r.charAt(0));
                }
        }
        String op="";
        boolean cerrado=false;
        Object embed=X.toText(request.getAttribute("#embed"));

//        request.setAttribute("title",""+X.gson.toJson(participaciones.get(id_encuesta))
////                getTitleEncuesta(request, response,id_encuesta)
//                );
        String controls=" ";
        int index=id_encuesta;
        if(ask){

            Object[] actualParticipacion=null;
            for(Object[] p:participaciones){
                if(p[1].equals(index)){
                    actualParticipacion=p;
                    break;
                }
            }
//            Si no se tiene participacion para la encuesta actual se niega acceso
            if(actualParticipacion==null)throw JServlet.AccessDeniedException;


            
            
            id_participacion=XUtil.intValue(actualParticipacion[0]);
//            se escoge el cuestionario que llenara

            id_cuestionario=XUtil.intValue(((Object[])actualParticipacion[5])[2]);
            id_encuesta=XUtil.intValue(((Object[])actualParticipacion[5])[0]);
            
            
            request.setAttribute("title",""+((Object[])actualParticipacion[5])[3]);
            roles=rolMap.get(((Object[])actualParticipacion[5])[1]);

            cerrado=XUtil.booleanValue(actualParticipacion[3]);
            List nr=new ArrayList();
//            los roles que no guardan relacion con la carrera
//            considere en un momento los q no guardan relacion agregarlos
//            pero los administrativos deben ser relacionados a una especialidad
//            ya sea usandose el escalafon deberia relacionarse su relacion con la especialidad
//            facultad/departamento/escuela
//            quizas deba hacer otra donde guarde los flag en general
//            if(ro!=null)nr.addAll(ro);
            if(roles!=null)for(Object r:roles)if(!nr.contains(r))nr.add(r);
            roles=nr;
            if(tipoParticipante==null){
                tipoParticipante=JPA.getInstance().getEntityManager().createNativeQuery("SELECT * FROM sva_tipo_participante").getResultList();
            }
            boolean todos=true;
            if(!XUtil.isEmpty(actualParticipacion[9])){
                roles=new ArrayList();
                for(Character c:((String)actualParticipacion[9]).toCharArray())roles.add(c);
            }else if(roles.isEmpty()){
                List<Character> rolesGeneral=rolMap.get(0);
                if(rolesGeneral!=null&&rolesGeneral.contains('A')){
                    roles.add('A');
                }//else
                   // roles.add('G');
            }
            if(!todos&&roles.size()>0){//si debe escogerse el rol mas representativo con sus derivadas secundarias o todas
                Map mm=new HashMap();
                for(Object[] rr:(List<Object[]>)tipoParticipante)mm.put(""+rr[0],rr);
                Object[] mayor=null;
                roles=new ArrayList();
                String rrr=XUtil.implode(roles,"");
                for(Character c:rrr.toCharArray()){
                    Object r[]=(Object[])mm.get(""+c);
                    if(r!=null){
                        if(!XUtil.booleanValue(r[2]))
                            roles.add((""+r[0]).charAt(0));
                        else if(mayor==null||XUtil.intValue(r[3])>XUtil.intValue(mayor[3]))
                            mayor=r;
                    }
                }
                if(mayor!=null)roles.add((""+mayor[0]).charAt(0));
                if(rrr.contains("D")&&!roles.contains('D'))roles.add('D');
                if(rrr.contains("B")&&!roles.contains('B'))roles.add('B');
                if(rrr.contains("C")&&!roles.contains('C'))roles.add('C');
            }
//            log(request,roles);
//            Desde registro de participacion se escoge los flags, se asegura q el principal este primero
//            if(rp[4] instanceof String){
//                String fla=rp[4]+" ";
//                if(fla.charAt(0)=='?'){
//                    //El primer caracter del flag sera puesto como rol principal
//                }else if(!roles.contains(fla.charAt(0))){
//                    roles.add(0,fla.charAt(0));
//                }
//            }
            if(!XUtil.isEmpty(roles)){
                for(Object r:roles){
                    op+=" OR "+r+"=1";
                }
                if(op.length()>1)op=op.substring(4);
            }
//            JSCore.log("op="+op);
            if("update".equals(request.getParameter("action"))){
                EntityManager jpa=(EntityManager)JPA.getInstance().getEntityManager();
                SvaEncuestaParticipacion svaParticipacion=null;
                if(XUtil.intValue(id_participacion)!=0)
                    svaParticipacion=jpa.find(SvaEncuestaParticipacion.class,id_participacion);
                if(svaParticipacion!=null)
                    try{
                        jpa.refresh(svaParticipacion);
                    }catch(Exception e){}
                if(svaParticipacion!=null)
                svaParticipacion=jpa.find(SvaEncuestaParticipacion.class,id_participacion);
                java.util.Date hoy=Calendar.getInstance().getTime();
                if(svaParticipacion==null){
                    svaParticipacion=new SvaEncuestaParticipacion();
                    svaParticipacion.setFechaReg(hoy);
                    svaParticipacion.setIdEncuesta(id_encuesta);
                    svaParticipacion.setFechaInicio(hoy);
                    svaParticipacion.setIdEspecialidad(XUtil.intValue(((Object[])actualParticipacion[5])[1]));
                    svaParticipacion.setIdUsuario(user.getIdDir());
                    svaParticipacion.setIdDir(user.getIdDir());
                    svaParticipacion.setFlag(""+(roles.size()>0?roles.get(0):" "));
                    svaParticipacion.setFlags(roles.size()>0?XUtil.implode(roles,""):"");
                }
//                esto no sirve si no es q fue registrado explicitamente por otro
                if(svaParticipacion.getFechaInicio()==null){
                    svaParticipacion.setFechaInicio(hoy);
                }
                if("?".equals(svaParticipacion.getFlag())||XUtil.isEmpty(svaParticipacion.getFlag())){
//                    debe considerarse q los flag debieran cambiar hasta q el participante cierre su formulario
                    svaParticipacion.setFechaInicio(hoy);
                    svaParticipacion.setFlag(""+(roles.size()>0?roles.get(0):" "));
                    svaParticipacion.setFlags(roles.size()>0?XUtil.implode(roles,""):"");
                }
                EntityTransaction t=JPA.getInstance().getTransaction(this);
                if(svaParticipacion.getIdParticipacion()==null){
                    jpa.persist(svaParticipacion);
                    if(id_cuestionario==4){
                        Object m=router.getModule(request,"oceda.encuesta");
                        m.getClass().getMethod("createParticipacion",HttpServletRequest.class,
                                HttpServletResponse.class,
                                svaParticipacion.getClass(),actualParticipacion.getClass()
                                ).invoke(m,request,response,svaParticipacion,actualParticipacion);
                    }
                }
                try{
                    List<Object[]> resp=(List<Object[]>) request.getSession().getAttribute("ask_"+index);
                    Query insertRespuestaTexto=jpa.createNativeQuery(_JDBC.sql("INSERT INTO sva_respuesta_texto VALUES(:id_participacion,:id_encuesta,:id_dir,:id_pregunta,:respuesta)")).
                            setParameter("id_encuesta",id_encuesta).
                            setParameter("id_participacion",svaParticipacion.getIdParticipacion()).
                            setParameter("id_dir",user.getIdDir());
                    Query updateRespuestaTexto=jpa.createNativeQuery(_JDBC.sql("UPDATE sva_respuesta_texto SET respuesta=:respuesta WHERE id_encuesta=:id_encuesta AND id_dir=:id_dir AND id_pregunta=:id_pregunta")).
                            setParameter("id_encuesta",id_encuesta).
                            setParameter("id_dir",user.getIdDir());
                    Query insertRespuesta=jpa.createNativeQuery(_JDBC.sql("INSERT INTO sva_respuesta VALUES(:id_participacion,:id_encuesta,:id_dir,:id_pregunta,:respuesta)")).
                            setParameter("id_encuesta",id_encuesta).
                            setParameter("id_participacion",svaParticipacion.getIdParticipacion()).
                            setParameter("id_dir",svaParticipacion.getIdDir());
                    Query updateRespuesta=jpa.createNativeQuery(_JDBC.sql("UPDATE sva_respuesta "
                            + "SET id_opcion=:respuesta "
                            + "WHERE id_participacion=:id_participacion AND id_pregunta=:id_pregunta")).
                            setParameter("id_participacion",svaParticipacion.getIdParticipacion());
                    for(Object[] r:resp){
                        switch((Integer)r[3]){
                            case 0:
                            case 1:
                            case 4:
                            case 11:
                                r[0]=request.getParameter("i_"+r[1]+"_0");
                                if(r[0]!=null)r[0]=XUtil.intValue(r[0]);
//                                print("xtype=radio P"+r[1]+"="+r[0]);
                                break;
                            case 2:
                                r[0]=X.toText(request.getParameter("i_"+r[1]+"_0"));
//                                print("xtype=textarea P"+r[1]+"='"+r[0]+"'");
                                break;
                            case 3:
                                r[0]=request.getParameter("i_"+r[1]+"_0");
                                if(r[0]!=null)r[0]=XUtil.intValue(r[0]);
//                                print("xtype=combo P"+r[1]+"="+r[0]);
                                break;
                        }
                    }
                    for(Object[] row:resp){
                        switch((Integer)row[3]){
                            case 0:
                            case 1:
                            case 3://combobox
                            case 4:
                            case 11:
//                                Solo se evaluara si no se recibe null
                                if(row[0]!=null&&!row[0].equals(row[2])){
                                    X.log("row="+X.gson.toJson(row));
                                    if(row[2]==null){
                                        insertRespuesta.
                                            setParameter("id_pregunta",row[1]).
                                            setParameter("respuesta",row[0]).
                                        executeUpdate();
                                    }else if(((Integer)row[0])!=0){
                                        updateRespuesta.
                                            setParameter("id_pregunta",row[1]).
                                            setParameter("respuesta",row[0]).
                                        executeUpdate();
                                    }
                                }
                                break;
                            case 2:
                                if(!row[0].equals(row[2])){
                                    X.log("row="+X.gson.toJson(row));
                                    if(row[2]==null){
                                        if(!(XUtil.isEmpty(row[0])))
                                        insertRespuestaTexto.
                                                setParameter("id_pregunta",row[1]).
                                                setParameter("respuesta",row[0]).
                                        executeUpdate();
                                    }else{
                                        X.log(" se grabara respuesta='"+row[0]+"' en p="+row[1]);
                                        updateRespuestaTexto.
                                                setParameter("id_pregunta",row[1]).
                                                setParameter("respuesta",row[0]).
                                        executeUpdate();
                                    }
                                }
                        }
                    }
                    int faltan=0;
//                    cuenta y confirma los movimiento de nuevo a antiguo valor
                    for(Object[] row:resp){
                        switch((Integer)row[3]){
                            case 0:
                            case 1:
                            case 3:
                            case 4:
                            case 11:
                                if(row[0]!=null){
                                    if(((Integer)row[0])!=0)
                                        row[2]=row[0];
                                }
                                if(XUtil.intValue(row[2])<1){
                                    X.log("falta="+XUtil.implode(row,","));

                                    faltan++;
                                }
                                break;
                            case 2:
                                if(!XUtil.isEmpty(row[0]))
                                    row[2]=row[0];
                                else{
                                    X.log("falta="+XUtil.implode(row,","));
                                    faltan++;
                                }
                        }
                        row[0]=null;
                        if(((Integer)row[3])==10)row[0]=Store.NONE;
                    }
                    if(faltan==0&&!svaParticipacion.getCerrado()&&request.getParameter("cerrado")!=null){
                        cerrado=XUtil.booleanValue(request.getParameter("cerrado"))||XUtil.intValue(request.getParameter("cerrado"))>0;
                        svaParticipacion.setCerrado(cerrado);
                        if(cerrado)svaParticipacion.setFechaCierre(new java.util.Date());
                    }
                    if(svaParticipacion.getIdParticipacion()==null){
                        jpa.persist(svaParticipacion);
                    }else{
                        jpa.merge(svaParticipacion);
                    }
                    t.commit();
                    if(actualParticipacion[0]==null)actualParticipacion[0]=svaParticipacion.getIdParticipacion();
                    actualParticipacion[3]=svaParticipacion.getCerrado();
                    actualParticipacion[6]=svaParticipacion.getFechaInicio();
                    actualParticipacion[7]=svaParticipacion.getFechaCierre();

                    router.die(request,response,"{success:true,cerrado:"+cerrado+",participacion:"+actualParticipacion[0]+",faltan:"+faltan+",msg:'"+JServlet.toJS(faltan==0?"Formulario completo, puede cerrar su encuesta para dar como finalizada su participación, despues de cerrarla ya no podra modificar sus respuestas.":"Cambios guardados.")+"'}");
                }catch(Exception e){
                    JPA.getInstance().rollback(this,e);
                    router.die(request,response,"{'success':false,'msg':"+X.gson.toJson(e.toString())+"}");
                }
                return;
            }
        }else{
            ResultSet pResultSet=null;
            ResultSet encuesta=(ResultSet) request.getAttribute("encuesta");
            id_cuestionario=XUtil.intValue(encuesta.getInt("id_cuestionario"));
            pResultSet=_JDBC.getCnx(request).createStatement().executeQuery("SELECT * FROM sva_encuesta_participacion WHERE id_participacion="+id_participacion);
            if(!pResultSet.next()) throw JServlet.PageNoFoundException;
            if(preview){
                List<Object[]> data=getTypes(request,id_cuestionario);
                if(data.size()>1){
                    for(Object row[]:data){
                        boolean ck=false;
                        for(Object r:roles){
                            if((((Character)r)).charValue()==row[0].toString().charAt(0)){
                                ck=true;
                                break;
                            }
                        }
                        controls+="{boxLabel:'"+row[1]+"',inputValue:'"+row[0]+"',checked:"+ck+"},";
                    }
                    controls="_.w('fieldset',{renderTo:'filter"+embed+"',collapsible:true,type:'vbox',defaults:{anchor:'100%'},title:'Tipo de Participante',items:["
                        + "{xtype:'jsform',url:'"+X.url(request)+"',standardSubmit: true,margin:0,buttonAlign:'right',renderTo:false,items:["
                            + "{xtype:'checkboxgroup',columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
                                + controls.substring(0,controls.length()-1)
                            + "]},"
                        + "],buttons:["
                            + "{xtype:'jsbutton',iconCls:'i-refresh',text:'Actualizar vista previa',anchor:false,handler:function(b){b.up('form').save();}}"
                        + "]}"
                    + "]});";

                 controls=(controls.length()>1?"<div id='filter"+embed+"'></div><div class=nl>mm</div><script>_.x(function(){"
                + controls+ "})</script>":"");
                }
            }else if(XUtil.intValue(id_participacion)>0){

                roles=new ArrayList();
                for(char c:pResultSet.getString("flags").toCharArray()){
                    roles.add(c);
                }
                if(roles.size()<1)roles.add('G');
                for(Object r:roles){op+=" OR "+r+"=1";}
                if(op.length()>1)op=op.substring(3);
            }
        }
//        alert(request,"participacion="+JSCore.gson.toJson(participacion)+" "+rmap+"id_participacion="+id_participacion+"&ask="+ask+"&preview="+preview+"&id_cuestionario="+id_cuestionario+"&roles="+roles);
        String sql=null;
        switch(id_cuestionario){
            case ENCUESTA:
            case 4:
                sql="SELECT "+
                (preview||XUtil.intValue(id_participacion)==0?"null id_opcion,":"sva_respuesta.id_opcion,")
                + "null respuesta,"
                + "quiz_pregunta.id_pregunta,"
                + "quiz_pregunta.id_tipo_pregunta,"
                + "quiz_pregunta.pregunta,"
                + "quiz_pregunta.id_categoria,"
                + "quiz_pregunta.id_lista,"
                + "isnull(sgc_encuesta_detalle.estado,1) estado "
                + "FROM quiz_pregunta "
                + (preview||XUtil.intValue(id_participacion)==0?"":
                    "LEFT OUTER JOIN sva_respuesta ON "
                    + "sva_respuesta.id_encuesta="+id_encuesta+" "
                    + "AND quiz_pregunta.id_pregunta=sva_respuesta.id_pregunta "
                    + "AND sva_respuesta.id_participacion="+id_participacion
                 )
                + " LEFT OUTER JOIN sgc_encuesta_detalle ON sgc_encuesta_detalle.id_encuesta="+id_encuesta+" AND sgc_encuesta_detalle.id_pregunta=quiz_pregunta.id_pregunta "
                + " LEFT OUTER JOIN sgc_fuente_pregunta ON sgc_fuente_pregunta.id_pregunta=quiz_pregunta.id_pregunta "
                + " WHERE quiz_pregunta.id_cuestionario="+id_cuestionario
                + (op.length()>0?" AND  ("+op+") ":"")
                + " ORDER BY numero,quiz_pregunta.id_pregunta";
                break;
        }
        int falta=0;
        JServlet.print(sql);
        Connection cnx;
        Statement stmt=(cnx=_JDBC.getCnx(request)).createStatement();
        ResultSet rs=stmt.executeQuery(_JDBC.sql(sql));
        ArrayList<Object[]> preguntas=new ArrayList();
        ArrayList opciones=new ArrayList();
        ArrayList<Object[]> respuestas=new ArrayList();
        ArrayList id_pregunta_texto=new ArrayList();
        Map<Integer,Object[]> pmap=new HashMap();
        while(rs.next()){
            ArrayList items=new ArrayList();
            ResultSet rs2=cnx.createStatement().executeQuery("SELECT id_item,id_pregunta,descripcion,id_lista "
                    + "FROM quiz_pregunta_item WHERE id_pregunta="+rs.getInt("id_pregunta")+" ORDER BY id_item");
            while(rs2.next()){
                opciones.add(rs2.getInt("id_lista"));
                items.add(new Object[]{rs2.getInt("id_item"),rs2.getInt("id_lista"),rs2.getString("descripcion")});
            }
            String content="";
            int id_tipo_pregunta=rs.getInt("id_tipo_pregunta");
            Object[] rpreg=new Object[]{
                rs.getInt("id_pregunta"),
                id_tipo_pregunta,
                rs.getString("pregunta"),
                items,
                content,
                rs.getObject("id_opcion"),
                rs.getInt("id_categoria")
            };
            pmap.put(rs.getInt("id_pregunta"),rpreg);
            preguntas.add(rpreg);
//            Si una pregunta no tiene de respuesta una opcion se considerara el formulario no esta completo
            switch(id_tipo_pregunta){
                case 2://texto
                    id_pregunta_texto.add(rs.getInt("id_pregunta"));
                    break;
                case 0:
                case 1:
                case 3:
                case 4:
                case 11:
                    if(!(rs.getInt("id_opcion")>0))falta++;
                    respuestas.add(new Object[]{null,rs.getInt("id_pregunta"),rs.getObject("id_opcion"),rs.getInt("id_tipo_pregunta")});
                    break;
            }
            if(items.isEmpty()){
                opciones.add(rs.getInt("id_lista"));
                items.add(new Object[]{0,rs.getInt("id_lista"),""});
            }
        }
        rs=stmt.executeQuery("SELECT id_pregunta,respuesta FROM sva_respuesta_texto WHERE id_participacion="+id_participacion+" AND id_pregunta IN ("+XUtil.toString(id_pregunta_texto)+")");
        while(rs.next()){
            if(XUtil.isEmpty(rs.getObject("respuesta")))falta++;
            respuestas.add(new Object[]{null,rs.getInt("id_pregunta"),rs.getObject("respuesta"),2});
            id_pregunta_texto.remove(rs.getObject("id_pregunta"));
            pmap.get(rs.getInt("id_pregunta"))[5]=rs.getObject("respuesta");
        }
        for(Object id_pregunta:id_pregunta_texto){
           respuestas.add(new Object[]{null,id_pregunta,null,2});
        }

        for(Object[] rr:respuestas){
            String ss="[";
            for(Object d:rr)ss+=d+",";
            X.log(ss+"]");
        }
        if(ask){
            request.getSession().setAttribute("ask_"+index,respuestas);
//            request.getSession().setAttribute("asignaturas_"+id_encuesta,asignaturas);
        }
        rs=stmt.executeQuery("SELECT id_lista,id_opcion,opcion FROM quiz_opcion_lista WHERE id_lista IN ("+XUtil.toString(opciones)+")");
        opciones.clear();
        Object id=false;
        ArrayList opc=null;
        while(rs.next()){
            if(!id.equals(rs.getInt("id_lista"))){
                opciones.add(new Object[]{id=rs.getInt("id_lista"),opc=new ArrayList()});
            }
            opc.add(new Object[]{rs.getString("id_opcion"),rs.getString("opcion")});
        }
        List categoria=new ArrayList();
        XMap m=new XMap();
        for(Object[] p:preguntas){
            if(!m.containsKey(p[6])){
                m.put(p[6],new ArrayList());
                categoria.add(p[6]);
            }
            ((ArrayList)m.get(p[6])).add(p);
        }
        ResultSet rsCategoria=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_catepre,nombre FROM"
                + " quiz_categoria_pregunta WHERE id_catepre IN ("+XUtil.implode(categoria)+") "
                + (preview?" OR id_cuestionario="+id_cuestionario:"")
                + " ORDER BY numero,id_catepre");
        categoria.clear();
        if(m.containsKey(0))categoria.add(new Object[]{0,"NINGUNA",m.get(0)});
        while(rsCategoria.next()){
            categoria.add(new Object[]{rsCategoria.getInt(1),rsCategoria.getString(2),m.get(rsCategoria.getInt(1))});
        }
        XMap qMap=new XMap("questions",categoria,"options",opciones);
//        if(asignaturas.size()>0)qMap.put("cursos",asignaturas);
        request.setAttribute("body","<style>"
                + ".nuevo{background:#CDFFCD;}"
            + ".i-lock{background-image:url("+X.url("images/lock.png")+") !important;}"
            + ".x-fieldset-header-text-collapsible{width:100%;font-size:13px}"
            + ".x-fieldset-header-text{width:100%;font-size:13px}"
            + ".x-tool-default{position:absolute}"
            + "</style>"
            + controls
            + "<div id='form"+embed+"'></div><script>_.x(function(){"
                + "_.create('_.form.QuizPanel',{"
                + "data:"+X.gson.toJson(qMap)+","
                    + (!XUtil.isEmpty(embed)?"waitMsgTarget:'window-"+embed+"',":"")
                    + "typeQuiz:"+id_cuestionario+",handlerDefault:function(b,s){"
                    + (id_cuestionario==CUESTIONARIO?"var nf=b.up('fieldset').down('textarea[name=t_s_'+b.name.split('_')[1]+']');"
                    + "if(s){if(!nf)nf=b.up('fieldset').add({xtype:'textarea',fieldLabel:'Propuestas de mejora',anchor:'100%',grow:true,name:'t_s_'+b.name.split('_')[1],id:'t_s_'+b.id});"
                    + "nf.setDisabled(b.inputValue==1);"
                    + "nf.setVisible(b.inputValue!=1);}":"")
                    + "},"
                    + (ask&&!cerrado?"buttons:["
                    + "{xtype:'jssave',id:'#b"+embed+"',tooltip:'"+JServlet.toJS("<div style=\"padding: 1px 2px 1px 17px;font-weight:bold;background: transparent url("+X.url("images/about-16.png")+")  left top no-repeat; padding-left:20px\">Cierra el formulario dando por finalizada la participación, despues no podra hacer cambios.</div>")+"',text:'Cerrar formulario',iconCls:'i-lock',disabled:"+(falta>0)+","
                    + "submit:{ok:function(f){window.location.reload()},validate:true,standardSubmit2:true,params:{cerrado:1}}},'->',"
                    + "{xtype:'jssave',"
                    + "submit:{ok:function(f,r){"
                    + "Ext.getCmp('#b"+embed+"').setDisabled(r.result.faltan>0)}}}"
                    + "],":"buttonAlign:'center',buttons2:[{iconCls:'i_print',xtype:'jsbutton',text:'Imprimir',handler:function(b){"
                    + "var v=document.createElement(\"iframe\");"
                    + "v.src='about:blank';"
                    + "var doc =v.document;"
                    + "if(v.contentDocument)"
                    + "doc =v.contentDocument;"
                    + "else if(v.contentWindow)"
                    + " doc =v.contentWindow.document;"
                    + "doc.open();"
                    + "doc.writeln(Ext.getDom(id).innerHTML);"
                    + ""
                    + ""
                    + "var d=v.contentWindow||v.contentDocument;"
                    + "alert(d);"
                    + "d.body.innerHTML='hola';"
                    + "_.print(v);"
                    + "}}],"
                    )
                    + "readOnly:"+!(ask&&!cerrado)+",url:'"+X.url(request)+"'"
                + "});Ext.QuickTips.init();"
            + "})</script>");
    }

    private String getMailText(String string, String string0, Object object) {
        return string;
    }

    public void listEncuesta(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("include","<script type='text/javascript' src='"+X.url("ux/jsuns.js")+"'></script>");
        User user=(User)request.getSession().getAttribute(X.USER);
        String embed=X.toText(request.getAttribute("#embed"));
        String body="<div id='form"+embed+"'></div><div id='grid"+embed+"'></div>";
        request.setAttribute("id_acper",((Tag)getCurrentPeriod(request)).getId());
        Object action=XUtil.isEmpty(request.getParameter("action"),request.getAttribute("action"));
        List data=Collections.EMPTY_LIST;
        if("export".equals(action)){
            List md=qRespuestaPreguntaEspecialidad.getMetadata();
            String c[]=new String[md.size()];
            for(int i=0,j=c.length;i<j;i++){
                c[i]=""+((Object[])md.get(i))[0];
            }
            request.setAttribute(X.PARAMS,new XMap(TableModel.class,new SimpleStore(data,c)));
//            JReportAction.export(request, response, user,qRespuestaPreguntaEspecialidad.getClass());
            return;
        }

        request.setAttribute("#meta",true);
        _JDBC.getResultList(request,qEncuesta);
        body+="<style>"
                + ".i-group{background-image:url("+X.url("images/user-group-16.png")+");}"
            + ".i-start{background-image:url("+X.url("images/play.png")+");}"
            + ".i-stop{background-image:url("+X.url("images/pause.png")+");}"
            + "</style>"
            + "<script>_.x(function(){"
               
                + "var m=new Ext.menu.Menu({"
                    + "listeners:{'beforeshow':function(m,eOpts){"
                        + "m.items.getAt(0).setVisible(!m.data.activo);"
                        + "m.items.getAt(1).setVisible(m.data.activo);"
                    + "}},"
                    + "items:["
                    + "{text:'Activar',iconCls:'i-start',handler:function(b){"
                        + "Ext.Ajax.request({"
                        + "url:'"+X.url("admin/oceca/encuesta/")+"'+m.data.id_encuesta,"
                        + "waitMsg:'Actualizando...',params: {action:'activo'},"
                        + "failure:function(){console.log('failure');}"
                        + "});"
                    + "}},"
                    + "{text:'Detener',iconCls:'i-stop',handler:function(b){"
                        + "Ext.Ajax.request({"
                        + "url:'"+X.url("admin/oceca/encuesta/")+"'+m.data.id_encuesta,"
                        + "waitMsg:'Actualizando...',params: {action:'activo'},"
                        + "failure:function(){console.log('failure');}"
                        + "});"
                    + "}}"

                    + "]"
                + "});"
                + "var f=JSCore.w('jsfilter',{items:["
                + ((XAction)router.getModule(request, response,"oceda")).getComponent(request, response,user)
                + ",{xtype:'jsfieldcontainer',items:["
                + "{xtype:'jstextfield',name:'cuestionario'},"
                + "{xtype:'jscombobox',flex:0,name:'activo',store:new Ext.data.ArrayStore({data:["
                + "[1,'SI'],"
                + "[0,'NO']"
                + "],fields:['v','d']})}"
                + "]}],target:_.w('jsgrid',{"
                    + "clazz:'"+qEncuesta.getClass().getCanonicalName()+"',"
                    + "data:"+X.gson.toJson(data)+","
                    + "totalCount:"+request.getAttribute(X.COUNT)+","
                    + "fields:"+X.gson.toJson(qEncuesta.getMetadata())+","
                    + "getFilters:function(){return f;},"
                    + "columns:["
                    + "{xtype:'menucolumn',popup:function(){"
                     + "var me=new Ext.menu.Menu({"
                    + "items:["
                        + "{text:'Participantes',iconCls:'i-group',handler:function(b){"
                            + "_.o({url:'"+X.url("admin/oceca/encuesta")+"/'+me.data.id_encuesta+'/participacion'});"
                        + "}},"
                        + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                            + "_.o({url:'"+X.url("admin/oceca/encuesta")+"/'+me.data.id_encuesta+'/edit'});"
                        + "}},"
                        + "{text:'Eliminar',iconCls:'i-delete',handler:function(b){"
                            + "_.o({url:'"+X.url("admin/oceca/encuesta")+"/'+me.data.id_encuesta+'/eliminar'});"
                        + "}}"
                    + "]"
                + "});"
                + "return me;"
                    + "}},"
                    + "{dataIndex:'cod_acper',text:'Periodo',align:'center',width:80},"
                    + "{dataIndex:'nombre',text:'Cuestionario',flex:1},"
                    + "{dataIndex:'especialidad',flex:1,xtype:'textcolumn',tdValue:function(v,m,r){return "
                    + "'<a onclick=\"return _.o(this)\" href=\""+X.url("admin/oceca/encuesta/")+"'+r.data.id_encuesta+'\">'+v+'</a>';"
                    + "}},"
                    + "{dataIndex:'fecha_ini'},"
                    + "{dataIndex:'fecha_fin'},"
                    + "{xtype:'menucolumn',popup:m,bValue:function(v,m,r,b){b.iconCls=r.data.activo?'i-start':'i-stop'}},"
                    + "]"
                + "})"
                + "});"
            + "})</script>";
        request.setAttribute("body",body);
    }

//    public Message mail(HttpServletRequest request, HttpServletResponse response,String subject,String body,Message message,int index) throws Exception{
//        message.setSubject(subject);
//        List<Object[]> data=(List)request.getAttribute("#data");
//        message.setContent(body.replace("!nombre_completo",toText(data.get(index)[2])), "text/html");
//        return message;
//    }

    private void valoracionEstandar(HttpServletRequest request, HttpServletResponse response, int numero) throws IOException {
        router.die(request, response,"{success:true,msg:'ok'}");
        return;
    }

    public List getTypes(HttpServletRequest request,Object id_cuestionario) throws SQLException {
        List<Object[]> data=new ArrayList();
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery(_JDBC.sql("SELECT "
                + "sva_tipo_participante.id_tipo,"
                + "sva_tipo_participante.tipo_participante,cfg.id_tipo "
                + "FROM "
                + "sva_tipo_participante "
                + "inner join quiz_cuestionario ON quiz_cuestionario.id_cuestionario="+id_cuestionario+" "
                + "LEFT OUTER JOIN sva_intrumento_cfg cfg ON charindex(sva_tipo_participante.id_tipo,cfg.tipo_participante)>0 "
                + "AND cfg.id_tipo="+id_cuestionario+" "
                + " ORDER BY base DESC,sva_tipo_participante.tipo_participante"));
        int id=0;
        while(rs.next()){
            if(id==0&&rs.getInt(3)>0){
                id=rs.getInt(3);
                data.clear();
            }
            if(id==0||id==rs.getInt(3)){
                data.add(new Object[]{rs.getObject(1),rs.getObject(2)
                        +" "+rs.getInt(3)+" "+id_cuestionario

                });
            }
        }

        return data;
    }

    public void viewPregunta(HttpServletRequest request, HttpServletResponse response,Object id_pregunta) throws Exception {
        viewPregunta(request, response, id_pregunta,request.getAttribute("id_encuesta"));
    }

    private qPregunta qPregunta=new qPregunta();

    private void listPregunta(HttpServletRequest request, HttpServletResponse response){
        Object embed=X.toText(request.getAttribute("#embed"));
        User user=(User)request.getSession().getAttribute(X.USER);
        request.setAttribute("body","<div id='grid"+embed+"'></div><script>_.x(function(){"
            + "var m=new Ext.menu.Menu({"
                + "items:["
                    + "{text:'Editar',iconCls:'i-edit',handler:function(b){"
                    + "_.o({url:'"+X.url("admin/oceca/documento")+"/'+m.data.id_doc+'/edit'});"
                    + "}},"
                    + "{text:'Eliminar',iconCls:'i-delete',handler:function(b){"
                    + "_.o({url:'"+X.url("admin/oceca/documento")+"/'+m.data.id_doc+'/eliminar'});"
                    + "}}"
                + "]"
            + "});"
            + "_.w('jsgrid',{"
                + "clazz:'"+qPregunta.class.getCanonicalName()+"',"
                + "data:"+X.gson.toJson(_JDBC.getResultList(request,qPregunta))+",fields:"+X.gson.toJson(qPregunta.getMetadata())+",totalCount:"+request.getAttribute(X.COUNT)+","
                + "columns:["
                    + "{xtype:'menucolumn',popup:m"
//                    + (UserAction.access(request,admin_sgc,user)?"":",bValue:function(o,m,r){"
//                    + "return "+JSUtil.intValue(user.getIdDir())+">0&&(r.data.id_editor=="+user.getIdDir()+"||r.data.id_creador=="+user.getIdDir()+")"
//                    + "}")
                    + "},"
//                    + "{dataIndex:'codigo',width:120,align:'center'},"
                    + "{dataIndex:'pregunta',flex:1,tdValue:function(v,m,r){return '<A onclick=\"return _.o(this)\" href=\""+X.url("admin/sva/pregunta/")+"'+r.data.id_pregunta+'\">'+v+'</A>'}}"
//                    + "{dataIndex:'tipo_documento',width:220},"
//                    + "{dataIndex:'estado',width:120,align:'center'}"
                + "]"
            + "})"
        + "})</script>");
    }

    public String getEncuestaTitle(HttpServletRequest request,HttpServletResponse response,Object id_encuesta) throws Exception{
        ResultSet rs=(ResultSet) request.getAttribute("encuesta");
        if(rs==null){
            rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT "
                + "sva_encuesta_especialidad.id_encuesta,"
                + "sva_encuesta_especialidad.id_acper,"
                + "isnull(apc_periodo_academico.cod_acper,string(year(fecha_ini))) cod_acper, "
                + "sva_encuesta_especialidad.id_cuestionario,"
                + "quiz_cuestionario.nombre,"
                + "sva_encuesta_especialidad.activo,"
                + "ifnull(sva_encuesta_especialidad.id_especialidad,0) id_especialidad,"
                + "ifnull(aps_especialidad.cod_especialidad,'00') cod_especialidad,"
                + "case when sva_encuesta_especialidad.id_especialidad>0 then aps_especialidad.especialidad else 'GENERAL' end especialidad "
                + "FROM sva_encuesta_especialidad "
                + "LEFT OUTER JOIN quiz_cuestionario ON quiz_cuestionario.id_cuestionario=sva_encuesta_especialidad.id_cuestionario "
                + "LEFT OUTER JOIN aps_especialidad ON sva_encuesta_especialidad.id_especialidad=aps_especialidad.id_especialidad "
                + "LEFT OUTER JOIN apc_periodo_academico ON sva_encuesta_especialidad.id_acper=apc_periodo_academico.id_acper "
                + "WHERE sva_encuesta_especialidad.id_encuesta="+id_encuesta
            );
            if(!rs.next())throw JServlet.PageNoFoundException;
            request.setAttribute("encuesta",rs);

            List<Object[]> tabs=(List)request.getAttribute("#tabs");
            if(rs.getInt("id_cuestionario")==4){
                tabs.add(new Object[]{false,
                    X.url("admin/oceca/encuesta/"+id_encuesta
                    + "/resultado"),"Resultados",true});
            }

        }
        return rs.getString("nombre")+" "+rs.getObject("especialidad")+" "+rs.getObject("cod_acper");
    }

    private void formParticipacion(HttpServletRequest request, HttpServletResponse response,Object id_participacion) throws IOException, Exception {
        Object action=request.getAttribute("action");
        EntityManager jpa=JPA.getInstance().getEntityManager();
        SvaEncuestaParticipacion svaEncuestaParticipacion=JPA.getInstance().get(SvaEncuestaParticipacion.class, id_participacion);
        if("update".equals(request.getParameter("action"))||action!=null){
            EntityTransaction t=JPA.getInstance().getTransaction(this);
            try{
                if("reset".equals(action)){
                    svaEncuestaParticipacion.setCerrado(false);
                    svaEncuestaParticipacion.setFechaInicio(null);
                    svaEncuestaParticipacion.setFechaCierre(null);
                    jpa.createNativeQuery("DELETE FROM sva_respuesta WHERE id_participacion=:id_participacion").setParameter("id_participacion",id_participacion).executeUpdate();
                    jpa.createNativeQuery("DELETE FROM sva_respuesta_est WHERE id_participacion=:id_participacion").setParameter("id_participacion",id_participacion).executeUpdate();
                }else if("open".equals(action)){
                    svaEncuestaParticipacion.setCerrado(false);
                }else{
                    X.copy(request,svaEncuestaParticipacion);
                    User user=(User)request.getSession().getAttribute(X.USER);
                    if(svaEncuestaParticipacion.getIdParticipacion()==null){
                        svaEncuestaParticipacion.setFlags("");
                        svaEncuestaParticipacion.setDelta(svaEncuestaParticipacion.getIdDir());
                        svaEncuestaParticipacion.setFlag("?");
                        svaEncuestaParticipacion.setIdUsuario(user.getIdDir());
                    }
                }
                String rol[]=request.getParameterValues("rol");
                if(rol!=null){
                    String flags="";
                    List roles=Arrays.asList(rol);
                    ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_tipo,tipo_participante FROM sva_tipo_participante ORDER BY base DESC,tipo_participante");
                    while(rs.next()){
                        if(roles.contains(rs.getString(1)))
                            flags+=rs.getString(1);
                    }
                    if(!XUtil.isEmpty(flags))svaEncuestaParticipacion.setFlags(flags);
                }
                if("delete".equals(action)){
                    jpa.remove(svaEncuestaParticipacion);
                }else if(svaEncuestaParticipacion.getIdParticipacion()==null){
                    jpa.persist(svaEncuestaParticipacion);
                }else
                    jpa.merge(svaEncuestaParticipacion);
                    router.commit(request, response, t,false);
                    return;
            }catch(Exception e){
                JPA.getInstance().rollback(this,e);
                router.die(request, response,"{success:true,msg:'"+JServlet.toJS(e)+"'}");
            }
        }
        String nombre_completo=null;
        if(svaEncuestaParticipacion.getIdParticipacion()!=null){
            ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT nombre_completo "
                    + "FROM drt_personanatural WHERE id_dir="+svaEncuestaParticipacion.getIdDir());
            if(rs.next()){
                nombre_completo=rs.getString(1);
            }
            if(XUtil.isEmpty(nombre_completo))nombre_completo="INDEFINIDO";
            request.setAttribute("title",nombre_completo);
        }

        String typeItems=" ";
        int n=0;
        ResultSet rs=_JDBC.getCnx(request).createStatement().executeQuery("SELECT id_tipo,tipo_participante FROM sva_tipo_participante ORDER BY base DESC,tipo_participante");
        String flags=svaEncuestaParticipacion.getFlags();
        while(rs.next()){
            typeItems+="{boxLabel:'"+rs.getObject(2)+"',inputValue:'"+rs.getObject(1)+"'"+
                    ",checked:"+flags.contains(rs.getString("id_tipo"))+"},";
            n++;
        }
        if(n>0)typeItems=typeItems.substring(0,typeItems.length()-1);
        request.setAttribute("include","<script type='text/javascript' src='"+X.url("ux/jsuns.js")+"'></script>");
        Object embed=X.toText(request.getAttribute("#embed"));
        request.setAttribute("body","<div id='form"+embed+"'></div><script>_.x(function(){"
            + "_.w('jsform',{items:["
                + "{xtype:'hidden',name:'id_dir',fieldLabel:false"+ (svaEncuestaParticipacion.getIdDir()>0?",value:"+svaEncuestaParticipacion.getIdDir():"")+ "},"
                + "{xtype:'hidden',name:'flag',value:'"+(svaEncuestaParticipacion.getFlag())+"'},"
                + "{xtype:'hidden',name:'delta',value:"+svaEncuestaParticipacion.getDelta()+"},"

                 + "{xtype:'jsfieldcontainer',fieldLabel:'Nombre completo',items:["
                        + "{xtype:'jstextfield',readOnly:true,value:'"+JServlet.toJS(nombre_completo)+"',fieldLabel:false,name:'nombre_completo'},"
                        + "{xtype:'jssearch',flex:0,scfg:{url:'"+X.url("admin/ocid/directorio")+"',ok:function(s,w,b){"
                            + "var f=b.up('form'),d=s[0].data;"
                            + "f.down('[name=id_dir]').setValue(d.id_dir);"
                            + "f.down('[name=flag]').setValue(d.tipo.charAt(0));"
                            + "f.down('[name=delta]').setValue(d.delta);"
                            + "f.down('[name=nombre_completo]').setValue(d.nombre_completo);"
                        + "}}}"
                     + "]},"
                + "{xtype:'jsfieldcontainer',items:["
                    + "{xtype:'datefield',name:'fecha_inicio',value:'"+XDate.toString(svaEncuestaParticipacion.getFechaInicio())+"'},"
                    + "{xtype:'datefield',name:'fecha_cierre',value:'"+XDate.toString(svaEncuestaParticipacion.getFechaCierre())+"'}"
                + "]},"
                + (typeItems.length()>1?"{xtype:'checkboxgroup',style:'margin-top:7px',fieldLabel:'Tipo de Participante',height:"+(26*(int)Math.ceil(n/2.0))+",columns:2,defaults:{fieldLabel:false,name:'rol'},items:["
                + typeItems
                + "]},":"")
                + "{xtype:'checkbox',name:'cerrado',fieldLabel:'Estado',uncheckedValue:'0',checked:"+(svaEncuestaParticipacion.getCerrado())+",inputValue:'1',boxLabel:'Cerrado'}"
            + "],buttons:["
            + "{xtype:'jssave'}"
            + (svaEncuestaParticipacion.getIdParticipacion()!=null?",{xtype:'jsdelete'}":"")
            + "]});"
            + "})</script>");

    }
   */ 
}
