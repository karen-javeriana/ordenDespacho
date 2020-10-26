/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.web.utilidades;

import com.javeriana.ejb.enumerados.ESeveridadMensaje;
import com.javeriana.web.mb.SesionMB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.PrimeFaces;
import org.apache.commons.lang3.StringUtils;
import javax.el.ELContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Permite realizar metodos genericos que sirven para toda la aplicacion del
 * proyecto web.
 *
 * @author <a href="mailto:veracm@globalhitss.com">Carlos Vera</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class Util {

    private static final Logger LOG = Logger.getLogger(Util.class.getName());
    public static final String NOMBRE_LLAVE_TOKEN = "app.bean.sesion.pve";
    public static final String REGISTRO_CREADO = "El registro se creó satisfactoriamente.";
    public static final String REGISTRO_ACTUALIZADO = "El registro se actualizó satisfactoriamente.";
    public static final String REGISTRO_APROBADO = "El registro se aprobó satisfactoriamente.";
    public static final String REGISTRO_RECHAZADO = "El registro se rechazó satisfactoriamente.";
    public static final String CAMBIOS_SATISFACTORIOS = "Se actualizó la información satisfactoriamente.";
    public static final String MISMA_DESCRIPCION = "Ya existe un registro con la misma descripción.";
    public static final String MISMO_CODIGO = "Ya existe un registro con el mismo código.";
    public static final String CARGUE_MASIVO_EXITOSO = "Archivo procesado correctamente, por favor valide el log";
    public static final String CARGUE_EXITOSO = "Archivo procesado correctamente";
    public static final int ELEMENTOCERO = 0;
    public static final String ELEMENTOTABLA = "elementoTabla";
    public static final String PAGINATABLA = "paginaTabla";
    public static final String ERRORFECHAINICIALMAYOR = "Fecha inicial mayor a la fecha final";
    public static final String ERRORFECHAFINSOBREPASAACTUAL = "Fecha final mayor a la fecha actual";
    public static final String ERRORFECHAINICIOSOBREPASAACTUAL = "Fecha inicial mayor a la fecha actual";
    public static final String REENVIO_TOKEN_EXITOSO = "El token fue reenviado con éxito";
    public static final String ERROR_VALIDACION_RANGO_2_MESES = "Las fechas no pueden superar un rango de 2 meses";
    public static final String CORREO_INVALIDO = "Correo incorrecto";
    public static final String CORREO_EXISTE = "Correo existente";
    public static final String NO_PROMOCION_ACTIVA = "No debe existir ninguna promoción activa";

    public static final String INFORMACION = "Información";
    public static final String ADVERTENCIA = "Advertencia";
    public static final String ERROR = "Error";

    public static final String CAMPO_REQUERIDO = "Campo requerido";
    public static final String CAMPO_NOREQUERIDO = "Campo no es requerido";
    public static final String VALOR_INCORRECTO = "Valor incorrecto";
    public static final String VALOR_VACIO = "Esta vacio";
    public static final String CODIGO_EXISTENTE = "Código existente";
    public static final String DESCRIPCION_EXISTENTE = "Descripción existente";
    public static final String VALOR_EXISTENTE = "Valor existente";
    public static final String NUMERO_CORTO = "Rango requerido es entre 7 - 15";
    public static final String NUMERO_LARGO = "Rango requerido es entre 7 - 15";
    public static final String DIRECCION_ERRONEA = "Dirección incorrecta";
    public static final String CONFIRMARCLAVE = "Contraseñas no coinciden validar";
    public static final String ERRORENCRIPTAR = "Error al momento de encriptar contraseñas";

    public static final int CANTIDAD_REGISTROS_TABLA_MOSTRAR = 5;
    public static final int CANTIDAD_REGISTROS_TABLA_MOSTRAR_X10 = 50;
    public static final String ESTADO_ACTIVO_TEXTO = "A";
    public static final String ESTADO_INACTIVO_TEXTO = "I";
    public static final String SI = "SI";
    public static final String NO = "NO";
    public static final String STRINGVACIO = " ";

    public static final String PREASIGNACION_EXITOSA = "Se realizó la pre-asignación del inventario satisfactoriamente.";
    public static final String ASIGNACION_EXITOSA = "Se realizó la asignación del inventario satisfactoriamente.";
    public static final String DEVOLUCION_EXITOSA = "Se realizó la devolución del inventario satisfactoriamente.";
    public static final String GARANTIA_EXITOSA = "Se realizó el envio a garantía del inventario satisfactoriamente.";
    public static final String END_LINE = "\r\n";
    public static final String PARAMETRIZACION_EXISTENTE = "Ya existe una parametrización con la ficha técnica.";
    public static final String PROCESO_SEGUNDO_PLANO = "Se está generando el informe en segundo plano.";
    public static final String FECHAS_MAYORES_A_2_MESES = "El rango entre fechas supera los dos meses";

    public static final String INFORME_MOVIDO_SFTP_SATISFACTORIAMENTE = "El informe fue creado correctamente en el servidor SFTP.";
    public static final String INFORME_NO_PUDO_SER_MOVIDO_SFTP = "El informe no pudo ser creado en el servidor SFTP, validar la conexión.";

    public static final String EJECUCION_EXITOSA = "Se ejecuto correctamente.";
    public static final String EJECUCION_FALLIDA = "Se genero un error durante la ejecución.";
    public static final int TAMANO_MAXIMO_DESCRIPCION = 200;
    public static final String MENSAJE_MAXIMO_CARACTERES_DESCRIPCION = "La descripción supera los 200 caracteres.";
    public static final String MENSAJE_FILTRO_VACIO_NOSERIAL = "Debe ingresar el código SAP ó seleccionar tipo y fabricante para consultar.";
    public static final String MENSAJE_FILTRO_INVALIDO_NOSERIAL = "No existe inventario para los valores del filtro.";
    public static final String CANTIDAD_MAYOR_CERO = "Cantidad debe ser mayor a 0.";

    public static final String EXTENSION_CSV = "csv";
    public static final String EXTENSION_XLSX = "xlsx";
    public static final String EXTENSION_XLS = "xls";

    public static final String URL_IFRAME_FACTURA_DIGITAL_APP_EXT = "http://190.145.0.162:7001/FACTURA-web/";
    public static final String URL_RETURN = "/pages/infoCliente/infoClienteInicio.xhtml";
    public static final String MODULO_CONTACTO = "Motivo Contacto";

    /**
     * Borra todos los mensajes en el contexto de la peticion.
     */
    public static final void borrarMensajes() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        Iterator<FacesMessage> it = contexto.getMessages();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    /**
     * Permite agregar mensajes en el contexto de la peticion.
     *
     * @param id del tag donde quiere que se muestre el mensaje
     * @param mensaje que se mostrara en pantalla
     */
    public static final void agregarMensajePorId(String id, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(mensaje));
    }

    /**
     * Crea un mensaje global mediante un contexto.
     *
     * @param mensaje
     */
    public static final void agregarMensajeGlobales(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, StringUtils.EMPTY));
    }

    /**
     *
     * Permite dar formato a fechas que sean tipo LocalDateTime
     *
     * @param dateTime
     * @param format
     * @return
     */
    public static String formatoFechaLocalDateTime(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    /**
     *
     * Permite dar formato a fechas que sean tipo LocalDateTime
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatoFechaLocalDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    /**
     *
     * Permite subir una variable a la sesion de Usuario
     *
     * @param id
     * @param obj
     *
     */
    public static void subirVariableSesion(String id, Object obj) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(id, obj);
    }

    /**
     *
     * Permite Retornar una variable en la sesion de Usuario
     *
     * @param id
     * @return Object
     *
     */
    public static Object bajarVariableSesion(String id) {
        return (Object) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(id);
    }

    /**
     *
     * Permite Guardar Notificaciones en la sesion de usuario
     *
     * @param msj
     * @param severidad
     *
     */
    public static void guardarNotificacionUsuarioSesion(String msj, String severidad) {
        try {
            SesionMB sesion = (SesionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Util.NOMBRE_LLAVE_TOKEN);
            sesion.setClaseMsj(severidad);
            sesion.setMsj(msj);
            sesion.setTituloMsj(Util.getTituloNotificacion(severidad));

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(NOMBRE_LLAVE_TOKEN, sesion);
        } catch (Exception ex) {
            String errorTraza = Arrays.toString(ex.getStackTrace());
            System.out.println(errorTraza);
            //LOG.error("Controlando ERROR al guardarNotificacionUsuarioSesion", ex);
        }
    }

    /**
     *
     * Permite Retornar la clase o severidad para notificaciones y mensajes
     *
     * @param severidad
     * @return
     */
    public static String getSeveridadMensaje(ESeveridadMensaje severidad) {
        return severidad.getNombre();
    }

    /**
     *
     * Permite Retornar El titulo para los mensajes notificaciones de acuerdo a
     * la clase bootstrap
     *
     * @param claseMsj
     * @return String
     *
     */
    public static String getTituloNotificacion(String claseMsj) {
        String titulo = Util.INFORMACION;

        if (claseMsj.equalsIgnoreCase(ESeveridadMensaje.WARNING.getNombre())) {
            titulo = Util.ADVERTENCIA;
        } else if (claseMsj.equalsIgnoreCase(ESeveridadMensaje.DANGER.getNombre())) {
            titulo = Util.ERROR;
        }

        return titulo;
    }

    /**
     * calcula los dias entre fecha inicial y fecha final
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     */
    public static long getDiasRangoFechas(LocalDateTime fechaInicial, Date fechaFinal) {
        long milisegundos = 24 * 60 * 60 * 1000; // Milisegundos al dia
        long dias = 0;
        dias = (fechaFinal.getTime() - Date.from(fechaInicial.atZone(ZoneId.systemDefault()).toInstant()).getTime()) / milisegundos;
        return dias;
    }

    /**
     * Traer el objeto SesionMB de la Sesion Actual
     *
     * @return
     */
//    public static SesionMB obtenerSesionActual() {
//        SesionMB sesion = (SesionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Util.NOMBRE_LLAVE_TOKEN);
//        if (sesion != null && sesion.getSesion() == null) {
//            PrimeFaces.current().executeScript("irLoginGeneral()");
//        }
//
//        return sesion;
//    }
    /**
     *
     * Actualizar el objeto SesionMB de la Sesion Actual
     *
     * @param sesion
     * @return
     *
     */
    public static boolean actualizarSesionMB(SesionMB sesion) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Util.NOMBRE_LLAVE_TOKEN, sesion);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     *
     * Obtiene la Lista de Escala Movil
     *
     * @return
     *
     */
    public static List<Integer> escalaMovil() {
        List<Integer> listaEscala = new ArrayList<>();
        int numero = 0;
        for (int i = 0; i < 99; i++) {
            numero++;
            listaEscala.add(numero);
        }
        return listaEscala;
    }

    /**
     * valida si la cadena es numero
     *
     * @param cadena
     * @return
     */
    public static boolean esNumero(String cadena) {
        return cadena.matches("[0-9]*");
    }

    /**
     * Encripta un texto dada una codigo que funciona como una clave de
     * encripcion y desencriptacion.
     *
     * @param texto
     * @param llave
     * @return
     * @throws java.lang.Exception
     */
    public static String encriptarTexto(String texto, String llave) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md.digest(llave.getBytes("utf-8"));
        SecretKey key = new SecretKeySpec(Arrays.copyOf(digestOfPassword, 24), "DESede");

        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] buf = cipher.doFinal(texto.getBytes("utf-8"));
        return new String(Base64.getEncoder().encodeToString(buf));
    }

    /**
     * desencripta un texto dada una codigo que funciona como una clave de
     * desencriptacion, con el cual se encripto.
     *
     * @param textoEncriptado
     * @param llave
     * @return
     * @throws java.lang.Exception
     *
     */
    public static String desencriptarTexto(String textoEncriptado, String llave)
            throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md.digest(llave.getBytes("utf-8"));
        SecretKey key = new SecretKeySpec(Arrays.copyOf(digestOfPassword, 24), "DESede");

        Cipher decipher = Cipher.getInstance("DESede");
        decipher.init(Cipher.DECRYPT_MODE, key);

        byte[] plainText = decipher.doFinal(Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8")));
        return new String(plainText, "UTF-8");
    }

    /**
     * Exportar archivo extension CSV
     *
     * @param nombreArchivo
     * @param cabecera
     * @param rows
     * @throws java.lang.Exception
     */
    public static void exportarArchivoCSV(String nombreArchivo, String cabecera,
            List<String> rows) throws Exception {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();

            response.reset();
            response.setContentType("text/comma-separated-values");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivo + ".csv\"");

            OutputStream output = response.getOutputStream();
            if (!StringUtils.isBlank(cabecera)) {
                output.write((cabecera + END_LINE).getBytes());
            }
            for (String s : rows) {
                output.write((s + END_LINE).getBytes());
            }

            output.flush();
            output.close();

            fc.responseComplete();
        } catch (IOException ex) {
            throw ex;
        }
    }

    /**
     * Lee un fichero y lo guarda en un String
     *
     * @param rutaArchivo ruta del archivo
     * @return archivo leido en un string
     * @throws java.io.FileNotFoundException
     */
    public static String obtenerFicheroString(String rutaArchivo)
            throws FileNotFoundException, IOException {
        String file = "";

        String cadena;
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);

        while ((cadena = b.readLine()) != null) {
            System.out.println(cadena);
            file = file + cadena;
        }
        b.close();

        return file;
    }

    /**
     * Lee un fichero y lo guarda en un String
     *
     * @param texto ruta del archivo
     * @param mapaLlaveReemplazo mapa que contiene la llave que se va a
     * reemplzar y el texto por el cual se va a reemplazar
     * @return archivo leido en un string
     * @throws java.io.FileNotFoundException
     */
    public static String reemplazarTexto(String texto, Map<String, String> mapaLlaveReemplazo) throws FileNotFoundException, IOException {
        for (String llave : mapaLlaveReemplazo.keySet()) {
            texto = texto.replace(llave, mapaLlaveReemplazo.get(llave));
        }

        return texto;
    }

    /**
     * Arma una tabla HTML a partir de una lista de Cabeceras y una matriz de
     * datos
     *
     * @param cabeceras etiquetas que van en el header de la tabla
     * @param datos texto que va en las columnas del cuerpo de la tabla, cada
     * registro de la lista interna es un row
     * @return tabla html
     * @throws java.io.FileNotFoundException
     */
    public static String armarTablaHtmlBodyMsgEmail(List<String> cabeceras,
            List<ArrayList<String>> datos) throws FileNotFoundException, IOException {
        if (cabeceras == null || datos == null) {
            return "";
        }

        if (datos.isEmpty()) {
            return "";
        }

        if (cabeceras.size() != datos.get(0).size()) {
            return "";
        }

        String data = "";

        String TR = "<tr>";
        String TR_CLOSE = "</tr>";
        String TH = "<th style=\"border-style: solid;border-width: 2px 1px 1px 2px;border-color: #dddddd;background: #dd1820;color: white\">";
        String TH_CLOSE = "</th>";
        String TD = "<td style=\"border-style: solid;border-width: 2px 1px 1px 2px;border-color: #dddddd\">";
        String TD_CLOSE = "</td>";

        data = data + TR;
        for (String head : cabeceras) {
            data = data + TH;
            data = data + head;
            data = data + TH_CLOSE;
        }
        data = data + TR_CLOSE;

        for (List<String> row : datos) {
            data = data + TR;
            for (String column : row) {
                data = data + TD;
                data = data + column;
                data = data + TD_CLOSE;
            }
            data = data + TR_CLOSE;
        }

        return data;
    }

    /**
     * Valida caracteres especiales
     *
     * @param cadenaValidar
     * @return
     */
//    public static boolean validarCaracteres(String cadenaValidar) {
//        Pattern mask = Pattern.compile(ConstantesValidaciones.EXPRESION_REGULAR_DE_TEXTO_INGRESADO);
//        return mask.matcher(cadenaValidar).matches();
//    }
//
//    /**
//     * Valida caracteres especiales
//     *
//     * @param cadenaValidar
//     * @return
//     */
//    public static boolean validarCaracteresSinEspacios(String cadenaValidar) {
//        Pattern mask = Pattern.compile(ConstantesValidaciones.EXPRESION_REGULAR_DE_TEXTO_INGRESADO_SIN_ESPACIOS);
//        return mask.matcher(cadenaValidar).matches();
//    }
    /**
     * valida que la cadena solo tenga letras
     *
     * @param cadena
     * @return
     */
//    public static boolean validarSoloTexto(String cadena) {
//        Pattern mask = Pattern.compile(ConstantesValidaciones.EXPRESION_REGULAR_SOLO_TEXTO_INGRESADO);
//        return mask.matcher(cadena).matches();
//    }
    /**
     * Obtiene el aliado de la sesion mediante un contexto.
     *
     * @return
     */
    public static String obtenerAliadoSesion() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idAliado");
    }

    /**
     * Obtiene el id del usuario de la sesion mediante un contexto.
     *
     * @return
     */
    public static String obtenerIdUsuarioSesion() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUsuario");
    }

    /**
     * Limpiar los espacios de un texto
     *
     * @param text
     * @return
     */
    public static String limpiarEspacios(String text) {
        return text.replaceAll("\\s", "");
    }

    /**
     * almacena llave - valor en el mapa de sesión
     *
     * @param llave
     * @param valor
     */
    public static void addAtributoSesion(String llave, Object valor) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(llave, valor);

    }

    /**
     * recupera el valor de la llave en el mapa de sesión
     *
     * @param llave
     * @return
     */
    public static Object getAtributoSesion(String llave) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(llave) == null
                ? "" : FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(llave);
    }

    /**
     * redirecciona a la pagina 500 cuando se produce una excepción
     *
     * @param ex
     */
    public static void enviarPantallaException(Exception ex) {
        Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
        String titleMensaje = "Excepción Controlada";
        titleMensaje = titleMensaje.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\"", "").replaceAll("\'", "");

        List<StackTraceElement> listaExc = Arrays.asList(ex.getStackTrace());
        List<String> listaCause = new ArrayList<>();

        StringBuilder error = new StringBuilder();
        error.append("EXCEPCIÓN CAUSADA POR: ").append("</br>");
        error.append("---------------------- ").append("</br>");
        error.append("</br>");
        if (ex.getCause() != null) {
            for (String word : ex.getCause().toString().split(" ")) {
                listaCause.add(word);
            }
        }
        for (String element : listaCause) {
            error.append(element).append(" ");
        }
        error.append("</br>").append("</br>");
        error.append("PILA DEL ERROR: ").append("</br>");
        error.append("--------------- ").append("</br>");
        error.append("</br>");
        for (StackTraceElement element : listaExc) {
            error.append(element.toString()).append("</br>");
        }

        String error500 = error.toString().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\"", "").replaceAll("\'", "");

        PrimeFaces.current().executeScript("localStorage.setItem('error500Title', '" + titleMensaje + "')");
        PrimeFaces.current().executeScript("localStorage.setItem('error500', '" + error500 + "')");
        PrimeFaces.current().executeScript("$('.page-content--bge5').hide();");
        PrimeFaces.current().executeScript("irError500()");
    }

    public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

//    /*
//    * Permite validar un rango de fechas en meses
//     */
//    public static boolean esValidoRangoFecha(String fechaInicio, String fechaFin,
//            int calendarMeses) throws Exception {
//        return UtilEjb.esValidoRangoFecha(fechaInicio, fechaFin, calendarMeses);
//    }
    /**
     * Exportar archivo dada su ruta exacta
     *
     * @param ruta
     * @throws java.lang.Exception
     */
    public static void exportarArchivo(String ruta) throws Exception {
        try {
            File f = new File(ruta);

            String nombreArchivo = f.getName();

            //se crean los objetos para enviar la petición de descarga
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
            response.reset();
            response.setContentType("text/comma-separated-values");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivo);
            //objeto para escribir el archivo
            ServletOutputStream out = response.getOutputStream();

            //OutputStream output = new FileOutputStream(nombreArchivo);
            byte[] buf = new byte[8192];
            FileInputStream is = new FileInputStream(f);

            int c = 0;

            while ((c = is.read(buf, 0, buf.length)) > 0) {
                out.write(buf, 0, c);
                out.flush();
            }

            out.flush();
            out.close();

            fc.responseComplete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * método que valida la cantidad máxima de caracteres permitido para el
     * campo descripción
     *
     * @param texto
     * @param tamano
     * @return
     */
    public static boolean esValidoTamanoTexto(String texto, int tamano) {
        return texto != null ? texto.length() <= tamano : false;
    }

    /**
     * Permite validar la extension del archivo que se va a importar.
     *
     * @param nombreArchivo
     * @param extension
     * @return true si la extension es .csv de lo contrario false.
     */
//    public static boolean validarExtensionArchivo(String nombreArchivo, String extension) {
//        boolean resultado = true;
//
//        if (!extension.equalsIgnoreCase(UtilEjb.extensionArchivo(nombreArchivo))) {
//            resultado = false;
//        }
//        return resultado;
//    }
    /**
     * redirecciona a la pagina 500 cuando se produce una excepción
     *
     * @param ex
     * @param titulo
     */
    public static void enviarPantallaExceptionSinSesion(Exception ex, String titulo) {
        Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
        String titleMensaje = String.format(ex.getMessage(), titulo);
        titleMensaje = titleMensaje.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\"", "").replaceAll("\'", "");

        List<StackTraceElement> listaExc = Arrays.asList(ex.getStackTrace());
        List<String> listaCause = new ArrayList<>();

        StringBuilder error = new StringBuilder();
        error.append("EXCEPCIÓN CAUSADA POR: ").append("</br>");
        error.append("---------------------- ").append("</br>");
        error.append("</br>");
        if (ex.getCause() != null) {
            for (String word : ex.getCause().toString().split(" ")) {
                listaCause.add(word);
            }
        }
        for (String element : listaCause) {
            error.append(element).append(" ");
        }
        error.append("</br>").append("</br>");
        error.append("PILA DEL ERROR: ").append("</br>");
        error.append("--------------- ").append("</br>");
        error.append("</br>");
        for (StackTraceElement element : listaExc) {
            error.append(element.toString()).append("</br>");
        }

        String error500 = error.toString().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\"", "").replaceAll("\'", "");

        PrimeFaces.current().executeScript("localStorage.setItem('error500Title', '" + titleMensaje + "')");
        PrimeFaces.current().executeScript("localStorage.setItem('error500', '" + error500 + "')");
        PrimeFaces.current().executeScript("$('.page-content--bge5').hide();");
        PrimeFaces.current().executeScript("irError500()");
    }

    /**
     * Validar estructura de un Correo
     *
     * @param cadena
     * @return
     */
    public static boolean esCorreoValido(String cadena) {
        try {
            String email = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pat = Pattern.compile(email);
            Matcher mat = pat.matcher(cadena);
            return mat.find();
        } catch (Exception ex) {
            return false;
        }
    }

//    public static void showModalError(Exception ex, String modulo) {
//
//        CamposErrorDto infoError = new CamposErrorDto();
//
//        if (ex instanceof GeneralException) {
//            infoError = ((GeneralException) ex).getCamposError();
//        } else {
//            infoError = new CamposErrorDto();
//            infoError.setLineaError(ex.getStackTrace()[0].getLineNumber());
//            infoError.setArchivoError(ex.getStackTrace()[0].getClassName());
//            if (ex instanceof ServicosWebException) {
//                infoError.setTipoError(ETipoError.WEBSERVICES);
//                infoError.setDescripcion(((ServicosWebException) ex).getDescription());
//            } else if (ex instanceof ValidacionDatosException) {
//                infoError.setTipoError(ETipoError.VALIDACION);
//                infoError.setDescripcion(((ValidacionDatosException) ex).getDescription());
//            } else {
//                infoError.setTipoError(ETipoError.INTERNOS);
//                infoError.setDescripcion(infoError.getTipoError().getDescription());
//            }
//
//            infoError.setDetalleError(ex.getMessage() == null
//                    ? infoError.getTipoError().getDescription()
//                    : ex.getMessage());
//            infoError.setPasoProceso(ex.getStackTrace()[0].getMethodName());
//
//            infoError.setNombreExcepcion(ex.getClass().getCanonicalName());
//        }
//
//        infoError.setModuloError(modulo);
//
//        SesionMB sesion = obtenerSesionActual();
//        sesion.setCamposErrorDto(infoError);
//        sesion.setModalTypeNotification(ETipoNotificacion.ERROR);
//        PrimeFaces.current().executeScript("modalNotification()");
//    }
//
//    public static void showModalErrorBi() {
//
//        CamposErrorDto errordto = Util.obtenerSesionActual().getSesion().getErrordto();
//        if (errordto != null) {
//            SesionMB sesion = obtenerSesionActual();
//            errordto.setModuloError(MODULO_CONTACTO);
//            sesion.setCamposErrorDto(errordto);
//            sesion.setModalTypeNotification(ETipoNotificacion.ERROR);
//            PrimeFaces.current().executeScript("modalNotification()");
//        }
//
//    }
//
//    public static void showModalWarning(String mensajeWarning) {
//        SesionMB sesion = obtenerSesionActual();
//        sesion.setMensajeWarning(mensajeWarning);
//        sesion.setModalTypeNotification(ETipoNotificacion.ALERTA);
//        PrimeFaces.current().executeScript("modalNotification()");
//    }
    public static Object getManagedBean(String nameMb) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Object object = (Object) elContext.getELResolver().getValue(elContext, null, nameMb);
        return object;
    }

    public static Date convertirStringToDate(String fecha, String formato) {

        Date date = null;
        try {
            date = new SimpleDateFormat(formato).parse(fecha);
        } catch (ParseException ex) {
            return null;
        }
        return date;
    }

//    public static String getUserName() {
//        String userName = Util.obtenerSesionActual().getSesion().getUsuario();
//        String[] user = userName.split("@");
//        return user != null && user.length > 0 ? user[0] : "";
//    }
//
//    public static boolean isNumeric(String cadena) {
//        try {
//            Integer.parseInt(cadena);
//            return true;
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//    }
    /**
     * Método para encriptar con AES
     *
     * @param texto
     * @return
     * @throws CoreException
     */
    public static String encriptarAES(String texto, String llaveSecreta) throws UnsupportedEncodingException {
        String textoEncriptado = "";
        try {
            // Generamos una KEY
            Key key = new SecretKeySpec(llaveSecreta.getBytes("UTF-8"), "AES");

            // Se obtiene un cifrador AES
            Cipher aes = Cipher.getInstance("AES");

            // Se inicializa para encriptacion y se encripta el texto,
            // que debemos pasar como bytes.
            aes.init(Cipher.ENCRYPT_MODE, key);
            byte[] encriptado = aes.doFinal(texto.getBytes());

            // Se escribe byte a byte en base64 el texto
            Base64.Encoder encoder = Base64.getEncoder();
            textoEncriptado = encoder.encodeToString(encriptado);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();

        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();

        } catch (InvalidKeyException ex) {
            ex.printStackTrace();

        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();

        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();

        }
        return textoEncriptado;
    }

    /**
     *
     * Metodo para obtener el protocolo, host, puerto y path de la aplicación
     * del proyecto web.
     *
     * @author <a href="mailto:avilan@globalhitss.com">Napoleon Avila</a>
     * @version 1.0.0
     *
     * @return
     */
    public static String getProtocolHostPortPath() {
        return getProtocol() + "://" + getHost() + ":" + getPort() + getPath();
    }

    private static String getHost() {
        HttpServletRequest r_ = getHttpRequest();
        return r_.getServerName();
    }

    private static Integer getPort() {
        HttpServletRequest r_ = getHttpRequest();
        return r_.getServerPort();
    }

    private static String getPath() {
        HttpServletRequest r_ = getHttpRequest();
        return r_.getContextPath();
    }

    private static String getProtocol() {
        HttpServletRequest r_ = getHttpRequest();
        return r_.getScheme();
    }

    private static HttpServletRequest getHttpRequest() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest serv = (HttpServletRequest) fc.getExternalContext().getRequest();
        return serv;
    }

    public static void mostrarMensajeErrorFormulario(String id, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(mensaje);
        context.addMessage(id, message);
    }

    public static void mostrarMensajeErrorToast(String mensaje) {
        PrimeFaces.current().executeScript(String.format("localStorage.setItem('toast', '%s');", mensaje));
    }

}
