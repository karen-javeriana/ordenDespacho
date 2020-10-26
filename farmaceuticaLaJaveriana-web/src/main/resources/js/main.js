//Al Iniciar la Aplicacion y cada vez que se refresque la página, cuando el documento esté
//con el DOM cargado en su totalidad, se ejecuta ESTO:
$(document).ready(function () {
    try {
        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        // | PRECARGAR RESOLUCIÓN DEL DISPOSITIVO
        // -----------------------------------------------------------------------------------------
        // Carga manejadores para identificar la resolución de la pantalla
        cargarManejadorDeResolucion();
        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°

        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        // | PRECARGAR ELEMENTOS Y DATA NECESARIA PARA DISEÑO
        // -----------------------------------------------------------------------------------------

        // Carga los Carousels
        cargarCarousels();
        // Estilizar Combos
        selectLoad();
        // Anadir desvanecidos a modales
        desvanecidosModales();
        // Carga las funciones en responsive para seleccionar cuenta
        cargarFuncionComboCuentaResponsive();
        // Habilitar boton de envio de consulta express
        $("#idBtnEnviar").attr("disabled", "true");
        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°

        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        // | OCULTAR LOADER EN RESPONSIVE
        // -----------------------------------------------------------------------------------------
        // Ocultar loader en responsive
        var ocultarResponsive = localStorage.getItem("responsive");
        if (typeof ocultarResponsive !== 'undefined' && ocultarResponsive !== 'null' && ocultarResponsive !== null && ocultarResponsive === 'true') {
            ocultarBloqueo('loadResponsiveInfoCliente');
        }
        $('#loadResponsiveInfoCliente').hide();
        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°

        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        // FUNCIONES DE VISUALIZACIÓN AL CARGAR LA PÁGINA (USANDO LOCALSTORAGE)
        // -----------------------------------------------------------------------------------------
        // Selecciona el tab activo para líneas de servicio en responsive
        var idTabActivo = localStorage.getItem("idTabActivo");
        if (typeof idTabActivo !== 'undefined' && idTabActivo !== 'null' && idTabActivo !== null) {
            mostrarTabActivo(idTabActivo);
        } else {
            mostrarTabActivo('fixed-tab-1');
        }
        // Visualizar u ocultar el botón de menú en responsive
        var menuCrud = localStorage.getItem("menuCrud");
        if (typeof menuCrud !== 'undefined' && menuCrud !== 'null' && menuCrud !== null) {
            $('#btnCrudMenu').click();
            localStorage.setItem('menuCrud', null);
        }
        // Hace que se cargue la función mustra_oculta() lo que predetermina que el div estará oculto hasta llamar a la función nuevamente
        muestra_oculta('contenido');
        // Muestra las notificaciones tipo <toast>
        var toast = localStorage.getItem("toast");
        if (typeof toast !== 'undefined' && toast !== 'null' && toast !== null) {
            mostrarToast(toast.toString());
        }

        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    } catch (error) {
        console.log(error);
    }
});

function enableWereless() {
    $('#nombreRed').prop('disabled', false);
    $('#claveRed').prop('disabled', false);
    selectLoad();
}

function disableWereless() {
    $('#nombreRed').prop('disabled', true);
    $('#claveRed').prop('disabled', true);
    $('#nombreRed').val('');
    $('#claveRed').val('');
    selectLoad();
}

//Método para Anadir manejadores de funciones en los media query e identificar si estamos en responsive o no
function cargarManejadorDeResolucion() {
    try {
        // Mediaquery destinado al responsive (Resolución máxima de 839px)
        var mediaqueryList = window.matchMedia("(max-width: 839px)");
        function manejador(EventoMediaQueryList) {
            if (EventoMediaQueryList.matches) {
                localStorage.setItem('responsive', true);
            } else {
                localStorage.setItem('responsive', false);
            }
        }

        // Asociamos el manejador de evento
        mediaqueryList.addListener(manejador);
    } catch (error) {
        console.log(error);
    }
}

//Método para Anadir funciones a los combos de cuentas en responsive
function cargarFuncionComboCuentaResponsive() {
    try {
        $('#fixed-tab-1 .select2-selection__rendered').click(function () {
            $('.select2-results__option--highlighted').click(function () {
                localStorage.setItem("idTabActivo", "fixed-tab-1");
                mostrarBloqueo('loadResponsiveInfoCliente');
                var tabActivo = '#fixed-tab-1';
                mostrarTabActivo('fixed-tab-1');
                var lineaCuenta = $(tabActivo + ' .select2-selection__rendered')[0].innerHTML;
                $($(".infoCuenta-detalle-texto").filter(":contains('" + lineaCuenta + "')"))[0].click();
            });
        });
        $('#fixed-tab-2 .select2-selection__rendered').click(function () {
            $('.select2-results__option--highlighted').click(function () {
                localStorage.setItem("idTabActivo", "fixed-tab-2");
                mostrarBloqueo('loadResponsiveInfoCliente');
                var tabActivo = '#fixed-tab-2';
                mostrarTabActivo('fixed-tab-2');
                var lineaCuenta = $(tabActivo + ' .select2-selection__rendered')[0].innerHTML;
                $($(".infoCuenta-detalle-texto").filter(":contains('" + lineaCuenta + "')"))[0].click();
            });
        });
        $('#fixed-tab-3 .select2-selection__rendered').click(function () {
            $('.select2-results__option--highlighted').click(function () {
                localStorage.setItem("idTabActivo", "fixed-tab-3");
                mostrarBloqueo('loadResponsiveInfoCliente');
                var tabActivo = '#fixed-tab-3';
                mostrarTabActivo('fixed-tab-3');
                var lineaCuenta = $(tabActivo + ' .select2-selection__rendered')[0].innerHTML;
                $($(".infoCuenta-detalle-texto").filter(":contains('" + lineaCuenta + "')"))[0].click();
            });
        });
    } catch (error) {
        console.log(error);
    }
}

//Método para Anadir desvanecidos a modales
function desvanecidosModales() {
    try {
        var containerMod = $('.containerModal')[0];
        if (typeof containerMod !== 'undefined' && containerMod !== 'null' && containerMod !== null) {
            if (!$('.containerModal')[0].childNodes[1].childNodes[1].childNodes[1].classList.contains('btn-default') && !$('.containerModal')[0].childNodes[1].childNodes[1].childNodes[1].classList.contains('btn-warning') && !$('.containerModal')[0].childNodes[1].childNodes[1].childNodes[1].classList.contains('btn-danger')) {
                $(".containerModal").show(setTimeout(function () {
                    $(".containerModal").fadeOut("slow",
                            function () {
                                $(".containerModal").removeClass("show");
                                if (!$(".containerModal").hasClass("displayNone")) {
                                    $(".containerModal").addClass("displayNone");
                                }

                                if (!$(".modal-backdrop").hasClass("displayNone")) {
                                    $(".modal-backdrop").addClass("displayNone");
                                }

                                if ($(".containerModal").hasClass("displayBlock")) {
                                    $(".containerModal").removeClass("displayBlock");
                                }
                                $(".modal-backdrop").removeClass("show");
                            });
                }, 1000));

                opacarBacks();
            }
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para ir a los cruds
function irCrudMenu() {
    try {
        localStorage.setItem('menuCrud', '1');
        pulsarClickPorId('idCrudMenu');
    } catch (error) {
        console.log(error);
    }
}

//Método para Cargar los estilos a los combos
function selectLoad() {
    try {
        $('select.form-control').select2();
        $('select.multi-control').multiselect();
        cargarCarousels();
    } catch (error) {
        console.log(error);
    }
}

//Método para esconder el placeholder de un inputText
function esconderPlaceholder() {
    try {
        if (typeof $('.mdl-textfield__label') !== "undefined" && typeof $('.mdl-textfield__label') !== undefined && $('.mdl-textfield__label') !== 'null' && $('.mdl-textfield__label') !== null) {
            for (var i = 0; i < $('.mdl-textfield__label').length; i++) {
                if ($('.mdl-textfield__label')[i].htmlFor.length > 0) {
                    if (!$($('.mdl-textfield__label')[i]).hasClass('font-transparent')) {
                        $($('.mdl-textfield__label')[i]).addClass('font-transparent');
                    }
                }
            }
        }
    } catch (error) {
        console.log(error);
    }
}


//Método para desplegar y esconder detalles TOPS del cliente
function collapseDetalleTops() {
    try {
        cargarCarousels();

        $('#detalleTop1').toggle();
        $('#detalleTop2').toggle();
        $('#detalleTop3').toggle();
        $('#detalleTop4').toggle();
        $('#detalleTop5').toggle();
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente
function collapseOnlyDetail(id) {
    try {
        esconderDetalleById(id + '1');
        esconderDetalleById(id + '2');
        esconderDetalleById(id + '3');
        esconderDetalleById(id + '4');
        esconderDetalleById(id + '5');
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente
function esconderDetalleById(id) {
    try {
        if ($('#' + id).hasClass('display-inline-grid')) {
            $('#' + id).addClass('displayNone');
            $('#' + id).removeClass('display-inline-grid');
        } else if ($('#' + id).hasClass('displayNone')) {
            $('#' + id).addClass('display-inline-grid');
            $('#' + id).removeClass('displayNone');
        }

    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente
function esconderDetalleContentById(id) {
    try {
        if ($('#' + id).hasClass('display-contents-grid')) {
            $('#' + id).addClass('displayNone');
            $('#' + id).removeClass('display-contents-grid');
        } else if ($('#' + id).hasClass('displayNone')) {
            $('#' + id).addClass('display-contents-grid');
            $('#' + id).removeClass('displayNone');
        }

    } catch (error) {
        console.log(error);
    }
}
function soloMostrarDetalleContentById(id) {
    try {
        if ($('#' + id).hasClass('displayNone')) {
            $('#' + id).addClass('display-contents-grid');
            $('#' + id).removeClass('displayNone');
        }

    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente
function collapseFacturacionPostpago() {
    try {
        esconderDetalleFacturacionById('divCabeceraFacturacionPostpago');
        collapsedPanelById('divFacturacionPostpago');
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente cobranza
function collapseCobranzaPostpago() {
    try {
        esconderDetalleFacturacionById('divCabeceraCobranzaPostpago');
        collapsedPanelById('divCobranzaPostpago');
    } catch (error) {
        console.log(error);
    }
}

function collapseFacturacionPrepago() {
    try {
        esconderDetalleFacturacionById('divCabeceraFacturacionPrepago');
        collapsedPanelById('divFacturacionPrepago');
    } catch (error) {
        console.log(error);
    }
}
function collapseCobranzaPrepago() {
    try {
        esconderDetalleFacturacionById('divCabeceraCobranzaPrepago');
        collapsedPanelById('divCobranzaPrepago');
    } catch (error) {
        console.log(error);
    }
}

function collapseFacturacionHogar() {
    try {
        esconderDetalleFacturacionById('divCabeceraFacturacionHogar');
        collapsedPanelById('divFacturacionHogarHisto');
    } catch (error) {
        console.log(error);
    }
}

function collapseFinanciacionCobranzaHogar() {
    try {
        collapsedPanelById('divFinanciacionHogarHisto');
    } catch (error) {
        console.log(error);
    }
}

function collapseFinanciacionCobranzaMovilPostpago() {
    try {
        collapsedPanelById('divFinanciacionMovilPos');
    } catch (error) {
        console.log(error);
    }
}

function collapseFinanciacionCobranzaMovilPrepago() {
    try {
        collapsedPanelById('divFinanciacionMovilPre');
    } catch (error) {
        console.log(error);
    }
}

function collapseCobranzaHogar() {
    try {
        esconderDetalleFacturacionById('divCabeceraCobranzaHogar');
        collapsedPanelById('divCobranzaHogarHisto');
    } catch (error) {
        console.log(error);
    }
}

function collapseProductosFijos() {
    try {
        collapsedPanelById('collapseCuentas');
    } catch (error) {
        console.log(error);
    }
}

function collapseProductosMovil() {
    try {
        collapsedPanelById('collapseMovil');
    } catch (error) {
        console.log(error);
    }
}

//Métodos genericos para desplegar detalles del cliente
function collapsePostpago() {
    try {
        esconderDetalleFacturacionById('divCabeceraPostpago');
        collapsedPanelById('divPostpagoHistoHeader');
    } catch (error) {
        console.log(error);
    }
}

function collapsePrepago() {
    try {
        esconderDetalleFacturacionById('divCabeceraPrepago');
        collapsedPanelById('divPrepagoHistoHeader');
    } catch (error) {
        console.log(error);
    }
}

function collapseHogar() {
    try {
        esconderDetalleFacturacionById('divCabeceraHogar');
        collapsedPanelById('divHogarHisto');
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del cliente
function esconderDetalleFacturacionById(id) {
    try {
        if ($('#' + id).hasClass('displayFlex')) {
            $('#' + id).addClass('displayNone');
            $('#' + id).removeClass('displayFlex');
        } else if ($('#' + id).hasClass('displayNone')) {
            $('#' + id).addClass('displayFlex');
            $('#' + id).removeClass('displayNone');
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar segmentos
function desplegarSegmentos() {
    try {
        collapsedPanelById('collapsePostpago');
        collapsedPanelById('collapsePrepago');
        collapsedPanelById('collapseHogar');
    } catch (error) {
        console.log(error);
    }
}

//Método para evitar la ejecución de un script
function prevDef(e) {
    try {
        e.preventDefault();
    } catch (error) {
        console.log(error);
    }
}

//Método para que solo sea permitido introducir números desde el teclado
function soloNumeros(e) {
    try {
        var key = window.event ? e.which : e.keyCode;
        if (key < 48 || key > 57) {
            if (key !== 8) {
                e.preventDefault();
            }
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para simular click 
function pulsarClickPorId(id) {
    try {
        $('#' + id).click();
    } catch (error) {
        console.log(error);
    }
}
function pulsarClickPorIdConPadres(id) {
    try {
        $('[id="' + id + '"]').click();
    } catch (error) {
        console.log(error);
    }
}

//Método para mostrar u ocultar un panel collapse
function collapsedPanelById(id) {
    try {
        if ($('#' + id).hasClass('collapse')) {
            $('#' + id).addClass('expansion-panel-body');
            $('#' + id).removeClass('collapse');
        } else if ($('#' + id).hasClass('expansion-panel-body')) {
            $('#' + id).addClass('collapse');
            $('#' + id).removeClass('expansion-panel-body');
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para mostrar u ocultar un panel collapse y cambiar de color al panel abierto
function collapsedInfoDetalladaPanel(id, idCabecera) {
    try {
        var contieneClase = $('#' + idCabecera).hasClass('panelCuentaSelectedInterno');
        if (!contieneClase) {
            pulsarClickPorId('btnInfoClienteDetalle');
            if ($('#' + id).hasClass('collapse')) {
                $('#' + id).addClass('expansion-panel-body');
                $('#' + id).removeClass('collapse');
                $('#' + idCabecera).addClass('panelCuentaSelectedInterno');

                $('#detalleTop1').hide();
                $('#detalleTop2').hide();
                $('#detalleTop3').hide();
                $('#detalleTop4').hide();
                $('#detalleTop5').hide();
            } else if ($('#' + id).hasClass('expansion-panel-body')) {
                $('#' + id).addClass('collapse');
                $('#' + id).removeClass('expansion-panel-body');
                $('#' + idCabecera).removeClass('panelCuentaSelectedInterno');

                $('#detalleTop1').show();
                $('#detalleTop2').show();
                $('#detalleTop3').show();
                $('#detalleTop4').show();
                $('#detalleTop5').show();
            }
        } else if ($('#collapseInfoDetalle').hasClass('expansion-panel-body')) {
            $('#collapseInfoDetalle').addClass('collapse');
            $('#collapseInfoDetalle').removeClass('expansion-panel-body');
            $('#headingInfoClienteDetalle').removeClass('panelCuentaSelectedInterno');

            $('#detalleTop1').show();
            $('#detalleTop2').show();
            $('#detalleTop3').show();
            $('#detalleTop4').show();
            $('#detalleTop5').show();
        }
        // Ubicar pantalla en el elemento
        $('html, body').animate({
            scrollTop: $('#templatePages').offset().top
        }, 400);

        selectLoad();
    } catch (error) {
        console.log(error);
    }
}

//Método para mostrar u ocultar un panel collapse y cambiar de color al panel abierto
function collapsedPanelSelect(id, idCabecera, idPadre) {
    try {
        var contieneClase = $('#' + idCabecera).hasClass('panelCuentaSelectedInterno');
        var listaHermanos = $('#' + idPadre)[0].childNodes;
        if (typeof listaHermanos !== "undefined" && listaHermanos !== 'null' && listaHermanos !== null) {
            for (i = 0; i < listaHermanos.length; i++) {
                var idElemento = $(listaHermanos[i]).attr("id");
                if (typeof idElemento !== "undefined" && idElemento !== 'null' && idElemento !== null) {
                    if (idElemento.includes("cabecera")) {
                        if ($('#' + idElemento).hasClass('panelCuentaSelectedInterno')) {
                            $('#' + idElemento).removeClass('panelCuentaSelectedInterno');
                        }
                    }
                    if (idElemento.includes("div")) {
                        if ($('#' + idElemento).hasClass('expansion-panel-body')) {
                            $('#' + idElemento).addClass('collapse');
                            $('#' + idElemento).removeClass('expansion-panel-body');
                        }
                    }
                }
            }
        }

        if (!contieneClase) {
            if ($('#' + id).hasClass('collapse')) {
                $('#' + id).addClass('expansion-panel-body');
                $('#' + id).removeClass('collapse');
                $('#' + idCabecera).addClass('panelCuentaSelectedInterno');
            } else if ($('#' + id).hasClass('expansion-panel-body')) {
                $('#' + id).addClass('collapse');
                $('#' + id).removeClass('expansion-panel-body');
                $('#' + idCabecera).removeClass('panelCuentaSelectedInterno');
            }
        }
        // Ubicar pantalla en el elemento
        $('html, body').animate({
            scrollTop: $('#' + id).offset().top
        }, 400);
    } catch (error) {
        console.log(error);
    }
}

//Método para mostrar random de turnos
function generarTurno() {
    try {
        var letraTurno = String.fromCharCode(65 + Math.floor(Math.random() * 26));
        var turno = Math.floor(Math.random() * 100) + 1;
        localStorage.setItem("turno", letraTurno + '-' + turno);
        $('#turnoInicio').text(letraTurno + '-' + turno);
        $('#noCliente').hide();
        $('#cliente').show();
        $('#atenderBtn').attr("disabled", false);
    } catch (error) {
        console.log(error);
    }
}

//Método para Visualizar mas info del cliente
function abrirInfoCliente(id) {
    try {
        $('#' + id).toggleClass('active');
        $('.contact nav').toggleClass('active');
    } catch (error) {
        console.log(error);
    }
}

//Método para Visualizar Los errores de consola en la página de errores web
function mostrarMensajeError500() {
    try {
        var error500Title = localStorage.getItem("error500Title");
        if (typeof error500Title !== "undefined" && error500Title !== 'null' && error500Title !== null) {
            var msj = error500Title;
            $('#error500Title').html(msj);
        } else {
            var obj = $('#error500Title')[0].innerHTML;
            if (typeof obj === "undefined" || obj === 'null' || obj === null || obj.length === 0) {
                $('#error500Title').html('EXCEPCIÓN NO CONTROLADA');
            }
        }

        var error500 = localStorage.getItem("error500");
        if (typeof error500 !== "undefined" && error500 !== 'null' && error500 !== null) {
            var msj = error500;
            $('#error500').html(msj);
        } else {
            var obj = $('#error500')[0].innerHTML;
            if (typeof obj === "undefined" || obj === 'null' || obj === null || obj.length === 0) {
                $('#error500').html('Comuníquese con el Administrador del Aplicativo.');
            }
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para ir a la pantalla de inicio
function cerrarSistema() {
    try {
        var url = window.location.href;
        var res = url.split("/");
        var space = res.indexOf("farmaceuticaLaJaveriana-web");
        var i;
        var ruta = "";
        for (i = 0; i <= space; i++) {
            ruta = ruta + res[i] + "/";
        }
        window.location.replace(ruta);
    } catch (error) {
        console.log(error);
    }
}

//Método para ir a la pantalla de Error 500
function irError500() {
    try {
        var url = window.location.href;
        var res = url.split("/");
        var space = res.indexOf("farmaceuticaLaJaveriana-web");
        var i;
        var ruta = "";
        for (i = 0; i <= space; i++) {
            ruta = ruta + res[i] + "/";
        }

        window.location.replace(ruta + 'pages/error/500.xhtml?faces-redirect=true');
    } catch (error) {
        console.log(error);
    }
}

function showPanelTableOrders() {
    try {
        setInterval(function () {
            try {
                if ($('#tableOrdenes').hasClass('hideTablaOrdenes')) {
                    $('#tableOrdenes').removeClass('hideTablaOrdenes');
                }
            } catch (error) {
                console.log(error);
            }
        }, 200);
    } catch (error) {
        console.log(error);
    }
}

function showPanelTableAvisos() {
    try {
        setInterval(function () {
            try {
                if ($('#tableAvisos').hasClass('hideTablaAvisos')) {
                    $('#tableAvisos').removeClass('hideTablaAvisos');
                }
            } catch (error) {
                console.log(error);
            }
        }, 200);
    } catch (error) {
        console.log(error);
    }
}

function showPanelDetailOrder(nombreDivTablas, id, contador) {
    try {
        for (var i = 1; i <= contador; i++) {
            try {
                if ($('#' + nombreDivTablas + i).hasClass('hideOrdenes')
                        && i === id) {
                    $('#' + nombreDivTablas + i).removeClass('hideOrdenes');
                    $('#' + nombreDivTablas + i).addClass('showOrdenes');
                } else if ($('#' + nombreDivTablas + i).hasClass('showOrdenes')
                        && i !== id) {
                    $('#' + nombreDivTablas + i).removeClass('showOrdenes');
                    $('#' + nombreDivTablas + i).addClass('hideOrdenes');
                } else if ($('#' + nombreDivTablas + i).hasClass('showOrdenes')
                        && i === id) {
                    $('#' + nombreDivTablas + i).removeClass('showOrdenes');
                    $('#' + nombreDivTablas + i).addClass('hideOrdenes');
                }
            } catch (error) {
                console.log(error);
            }
        }
    } catch (error) {
        console.log(error);
    }
}



function showPanelDetailOrderTable(nombreDivTablas, id, contador) {
    try {
        for (var i = 1; i <= contador; i++) {
            try {
                if ($('#' + nombreDivTablas + i).hasClass('hideOrdenes')
                        && i === id) {
                    $('#' + nombreDivTablas + i).removeClass('hideOrdenes');
                    $('#' + nombreDivTablas + i).addClass('showOrdenes');
                } else if ($('#' + nombreDivTablas + i).hasClass('showOrdenes')
                        && i !== id) {
                    $('#' + nombreDivTablas + i).removeClass('showOrdenes');
                    $('#' + nombreDivTablas + i).addClass('hideOrdenes');
                } else if ($('#' + nombreDivTablas + i).hasClass('showOrdenes')
                        && i === id) {
                    $('#' + nombreDivTablas + i).removeClass('showOrdenes');
                    $('#' + nombreDivTablas + i).addClass('hideOrdenes');
                }
            } catch (error) {
                console.log(error);
            }
        }
    } catch (error) {
        console.log(error);
    }
}




function selectedAccount(id, contador, nombreDiv, nombreDivTablas) {
    try {
        for (var i = 1; i <= contador; i++) {
            if ($('#' + nombreDiv + i).hasClass('panelCuentas') && i === id) {
                $('#' + nombreDiv + i).removeClass('panelCuentas');
                $('#' + nombreDiv + i).addClass('panelCuentaSelected');
            } else if ($('#' + nombreDiv + i).hasClass('panelCuentaSelected')
                    && i !== id) {
                $('#' + nombreDiv + i).removeClass('panelCuentaSelected');
                $('#' + nombreDiv + i).addClass('panelCuentas');
            } else if ($('#' + nombreDiv + i).hasClass('panelCuentaSelected') && i == id) {
                $('#' + nombreDiv + i).removeClass('panelCuentaSelected');
                $('#' + nombreDiv + i).addClass('panelCuentas');
            }
        }
        showPanelDetailOrder(nombreDivTablas, id, contador);
    } catch (error) {
        console.log(error);
    }
}

function showHideOrdenes(nombrediv) {
    try {
        if ($(document.getElementById(nombrediv)).hasClass('hideOrdenes')) {
            $(document.getElementById(nombrediv)).removeClass('hideOrdenes');
            $(document.getElementById(nombrediv)).addClass('showOrdenes');
        } else if ($(document.getElementById(nombrediv)).hasClass('showOrdenes')) {
            $(document.getElementById(nombrediv)).removeClass('showOrdenes');
            $(document.getElementById(nombrediv)).addClass('hideOrdenes');
        }
    } catch (error) {
        console.log(error);
    }
}

function collapseDetalleHogar(id) {
    try {
        esconderDetalleById('detalleHogar1');
        esconderDetalleById('detalleHogar2');
        esconderDetalleById('detalleHogar3');
        esconderDetalleById('detalleHogar4');
        esconderDetalleById('detalleHogar5');
        esconderDetalleById('detalleHogar6');
        esconderDetalleById('detalleHogar7');
        collapsedPanelById(id);
    } catch (error) {
        console.log(error);
    }
}

function collapseDetalleMovil(id, tipo) {
    try {
        esconderDetalleById('detalle' + tipo + '1');
        esconderDetalleById('detalle' + tipo + '2');
        esconderDetalleById('detalle' + tipo + '3');
        esconderDetalleById('detalle' + tipo + '4');
        esconderDetalleById('detalle' + tipo + '5');
        esconderDetalleById('detalle' + tipo + '6');
        collapsedPanelById(id);
    } catch (error) {
        console.log(error);
    }
}

function mostrarDialog(id) {
    try {
        var dialog = document.querySelector('#' + id);
        var showDialogButton = document.querySelector('#btn-dialog-headear');
        if (!dialog.showModal) {
            dialogPolyfill.registerDialog(dialog);
        }
        showDialogButton.addEventListener('click', function () {
            dialog.showModal();
        });
        dialog.querySelector('.close').addEventListener('click', function () {
            dialog.close();
        });
    } catch (error) {
        console.log(error);
    }
}


function showHideOrdenHistorial(nombreDivTablas) {
    try {
        if ($('#' + nombreDivTablas).hasClass('hideOrdenes')) {
            $('#' + nombreDivTablas).removeClass('hideOrdenes');
            $('#' + nombreDivTablas).addClass('showOrdenes');
        } else if ($('#' + nombreDivTablas).hasClass('showOrdenes')) {
            $('#' + nombreDivTablas).removeClass('showOrdenes');
            $('#' + nombreDivTablas).addClass('hideOrdenes');
        }
    } catch (error) {
        console.log(error);
    }

}

function borrarColor(idCabecera) {
    try {
        for (var i = 0; i < $('#contad').length; i++) {
            alert(i);
            if ($('#' + idCabecera).hasClass('panelCuentaSelectedInterno')) {
                alert("entro");
                $('#' + idCabecera).removeClass('panelCuentaSelectedInterno');
            }
        }
    } catch (error) {
        console.log(error);
    }
}

function modalNotification() {
    try {

        var modal = document.getElementById("modalOverLoadNotification");
        $('#btnLoadModalNotification').click();
        if ($(modal).hasClass("displayNone")) {
            $(modal).removeClass('displayNone');
            $(modal).addClass('displayBlock');
        } else {
            $(modal).addClass('displayNone');
            $(modal).removeClass('displayBlock');
        }
    } catch (error) {
        console.log(error);
    }
}

function closemodalNotification() {
    try {
        var modal = document.getElementById("modalOverLoadNotification");
        $('#btnLoadModalNotification').click();
        $(modal).removeClass('displayBlock');
        $(modal).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function modalException() {
    try {
        var modal = document.getElementById("modalOverLoadException");

        $(modal).addClass('displayBlock');

    } catch (error) {
        console.log(error);
    }
}

function closemodal() {
    try {
        var modal = document.getElementById("modalOverLoadException");
        $(modal).removeClass('displayBlock');
        $(modal).addClass('displayNone');

    } catch (error) {
        console.log(error);
    }
}

function modalTransferirServicio() {
    try {
        var modal = document.getElementById("modalOverloadTransferirServicio");
        if ($(modal).hasClass("displayNone")) {
            $(modal).removeClass('displayNone');
            $(modal).addClass('displayBlock');
        } else {
            $(modal).addClass('displayNone');
            $(modal).removeClass('displayBlock');
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para abrir el detalle en el Modal
function lessModalNotification() {
    try {
        iconLess = document.getElementsByClassName("less");
        iconMore = document.getElementsByClassName("more");
        $(iconLess).removeClass('displayNone');
        $(iconLess).addClass('displayBlock');
        $(iconMore).removeClass('displayBlock');
        $(iconMore).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

//Método para cerrar el detalle en el Modal
function moreModalNotification() {
    try {
        iconLess = document.getElementsByClassName("less");
        iconMore = document.getElementsByClassName("more");
        $(iconMore).removeClass('displayNone');
        $(iconMore).addClass('displayBlock');
        $(iconLess).removeClass('displayBlock');
        $(iconLess).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function posicionarCursorId(id) {
    try {
        // Ubicar pantalla en el elemento
        $('html, body').animate({
            scrollTop: $('#' + id).offset().top
        }, 400);
        selectLoad();
    } catch (error) {
        console.log(error);
    }
}

//Método para cambiar de tag para los cruds
function cambiarTab(opc, id) {
    try {
        $('#' + id).click();
        localStorage.setItem("tab", opc.toString());
    } catch (error) {
        console.log(error);
    }
}

function ocultarCargandoCampanas() {
    try {
        $('#msgCamp').addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function mostrarBloqueo(bui) {
    try {
        PF(bui).show();
        var imageLoader = document.getElementById("imageLoader");
        var statusDialog = document.getElementById("statusDialog");
        $(imageLoader).removeClass('displayNone');
        $(statusDialog).addClass('loader');
        selectLoad();
    } catch (error) {
        console.log(error);
    }
}

function ocultarBloqueo(bui) {
    try {
        PF(bui).hide();
        var imageLoader = document.getElementById("imageLoader");
        var statusDialog = document.getElementById("statusDialog");
        $(statusDialog).removeClass('loader');
        $(imageLoader).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function cargarMatrizNodo(matriz, nodo, estrato, estado, contador) {
    try {
        document.getElementById('tituloCtaMatriz' + contador).innerHTML = "Cuenta Matriz";
        document.getElementById('ctaMatriz' + contador).innerHTML = matriz;
        document.getElementById('tituloNodo' + contador).innerHTML = "Nodo";
        document.getElementById('nodo' + contador).innerHTML = nodo;
        document.getElementById('tituloEstrato' + contador).innerHTML = "Estrato";
        document.getElementById('estrato' + contador).innerHTML = estrato;
        document.getElementById('tituloEstado' + contador).innerHTML = "Estado";
        document.getElementById('estado' + contador).innerHTML = estado;
    } catch (error) {
        console.log(error);
    }
}

function soloNumerosCondicion(e) {
    try {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toLowerCase();
        letras = "1234567890";
        especiales = [8];
        tecla_especial = false;
        for (var i in especiales) {
            if (key === especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) === -1 && !tecla_especial)
            return false;
    } catch (error) {
        console.log(error);
    }
}

function soloCondicionLetras(e) {
    try {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toLowerCase();
        letras = "abcdefghijklmnopqrstuvwxyz1234567890";
        especiales = [8, 32, 95];
        tecla_especial = false;
        for (var i in especiales) {
            if (key === especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) === -1 && !tecla_especial)
            return false;
    } catch (error) {
        console.log(error);
    }
}

function reproducirDonaPrepago(id, titulo, colores, nombres, valores) {
    try {
        var strColors = colores.substring(1, colores.length - 1).replace(/\s/g, '');
        var colorSet = strColors.split(',');
        CanvasJS.addColorSet("colorSet", colorSet);
        var strNombres = nombres.substring(1, nombres.length - 1);
        var nombreSet = strNombres.split(',');
        var strValores = valores.substring(1, valores.length - 1).replace(/\s/g, '');
        var valorSet = strValores.split(',');
        var dps = [];
        for (var i = 0; i < nombreSet.length; i++) {
            var identificacion = nombreSet[i] + " - " + parseFloat(valorSet[i]) + "MB";
            dps.push({y: parseFloat(valorSet[i]), legendText: identificacion});
        }

        var chartPrepago = new CanvasJS.Chart(id, {
            height: 240,
            animationEnabled: true,
            colorSet: "colorSet",
            title: {
                padding: 0,
                text: titulo,
                horizontalAlign: "center",
                fontSize: 13
            },
            legend: {
                horizontalAlign: "right",
                verticalAlign: "center",
                fontSize: 13,
                itemWrap: true
            },
            data: [{
                    innerRadius: 80,
                    type: "doughnut",
                    showInLegend: false,
                    toolTipContent: "{y}MB (#percent%)",
                    explodeOnClick: true,
                    dataPoints: dps
                }]

        });
        chartPrepago.render();
    } catch (error) {
        console.log(error);
    }
}

function reproducirDonaPostpago(id, titulo, colores, nombres, valores) {
    try {
        var strColors = colores.substring(1, colores.length - 1).replace(/\s/g, '');
        var colorSet = strColors.split(',');
        CanvasJS.addColorSet("colorSet", colorSet);
        var strNombres = nombres.substring(1, nombres.length - 1);
        var nombreSet = strNombres.split(', ');
        var strValores = valores.substring(1, valores.length - 1).replace(/\s/g, '');
        var valorSet = strValores.split(',');
        var dps = [];
        for (var i = 0; i < nombreSet.length; i++) {
            var identificacion = nombreSet[i] + " - " + parseFloat(valorSet[i]) + "MB";
            dps.push({y: parseFloat(valorSet[i]), legendText: identificacion});
        }

        var chartPostpago = new CanvasJS.Chart(id, {
            height: 240,
            animationEnabled: true,
            colorSet: "colorSet",
            title: {
                padding: 0,
                text: titulo,
                horizontalAlign: "center",
                fontSize: 13
            },
            legend: {
                horizontalAlign: "center",
                verticalAlign: "bottom",
                fontSize: 13,
                itemWrap: true
            },
            data: [{
                    innerRadius: 80,
                    type: "doughnut",
                    showInLegend: false,
                    toolTipContent: "{y}MB (#percent%)",
                    explodeOnClick: true,
                    dataPoints: dps
                }]

        });
        chartPostpago.render();
    } catch (error) {
        console.log(error);
    }
}

//Método para cargar estilos y funciones de los componentes Carousel
function cargarCarousels() {
    try {
        // Carousel OWL
        var owlCarousel = $('.owl-carousel');
        if (typeof owlCarousel !== 'undefined' && owlCarousel !== 'null' && owlCarousel !== null && owlCarousel.length > 0) {
            $('.owl-carousel').owlCarousel({
                loop: true,
                nav: true,
                items: 1,
                animateOut: 'fadeOut'
            });
            $("a.owl-prev").click(function () {
                $("div.owl-prev").click();
            });
            $("a.owl-next").click(function () {
                $("div.owl-next").click();
            });
        }

        // Carousel Flickity
        var carouselFli = $('.carousel');
        if (typeof carouselFli !== 'undefined' && carouselFli !== 'null' && carouselFli !== null && carouselFli.length > 0) {
            $('.carousel').flickity({
                cellAlign: 'left',
                freeScroll: false,
                contain: true,
                prevNextButtons: true,
                pageDots: false,
                wrapAround: true,
                autoPlay: 2000
            });
            $('.carousel').flickity('resize');
        }
    } catch (error) {
        console.log(error);
    }
}

function mostrarToast(mensaje) {
    try {

        $('#mensajeToast').html(mensaje);
        $('#snackbarToast').removeAttr('style');
        $('#snackbarToast').removeClass('displayNone');
        localStorage.setItem("toast", null);
    } catch (error) {
        console.log(error);
    }
}

function mostrarToastWithColor(mensaje, color) {
    try {

        $('#mensajeToast' + color).html(mensaje);
        $('#snackbarToast' + color).attr('style', 'display:block !important');
        $('#snackbarToast' + color).removeClass('displayNone');
        localStorage.setItem("toast", null);
    } catch (error) {
        console.log(error);
    }
}

function onStatusChange(data, id1, id2, idButton) {
    try {
        if (id2 !== null) {
            esconderDetalleById(id2);
        }
        var button = idButton !== null ? $('#' + idButton) : null;
        if (button !== null) {
            button.prop('disabled', true);
        }
        var item = id1 !== null ? $('#' + id1) : null;
        var status = data.status;
        if (status === "begin") {
            if (item !== null && item.hasClass('displayNone')) {
                item.removeClass('displayNone');
            }
        } else {
            if (item !== null && !item.hasClass('displayNone')) {
                item.addClass('displayNone');
            }
            if (id2 !== null) {
                esconderDetalleById(id2);
            }
            if (button !== null) {
                button.prop('disabled', false);
            }
        }
    } catch (error) {
        console.log(error);
    }
}

function onStatusChangeQdn(data, id1, id2, idButton) {
    try {
        if (id2 !== null) {
            soloMostrarDetalleContentById(id2);
        }
        var button = idButton !== null ? $('#' + idButton) : null;
        if (button !== null) {
            button.prop('disabled', true);
        }
        var item = id1 !== null ? $('#' + id1) : null;
        var status = data.status;
        if (status === "begin") {
            if (item !== null && item.hasClass('displayNone')) {
                item.removeClass('displayNone');
            }
        } else {
            if (item !== null && !item.hasClass('displayNone')) {
                item.addClass('displayNone');
            }
            if (id2 !== null) {
                soloMostrarDetalleContentById(id2);
            }
            if (button !== null) {
                button.prop('disabled', false);
            }
        }
    } catch (error) {
        console.log(error);
    }
}

function onStatusChangeButtons(data, idButtons) {
    try {
        var status = data.status;
        for (var i = 0; i < idButtons.length; i++) {
            var button = idButtons[i] !== null ? $('#' + idButtons[i]) : null;
            button.prop('disabled', true);
        }
        if (status !== "begin") {
            if (idButtons !== null) {
                for (var i = 0; i < idButtons.length; i++) {
                    var button = idButtons[i] !== null ? $('#' + idButtons[i]) : null;
                    button.prop('disabled', false);
                }
            }
        }
    } catch (error) {
        console.log(error);
    }
}

//Función para aplicar una clase dinámica en el responsive de la info detallada
$(".margin-content").on('click', function (event) {
    try {
        if (typeof $('#collapseInfoDetalle') !== 'undefined' && $('#collapseInfoDetalle') !== 'null' && $('#collapseInfoDetalle') !== null) {
            if (!$('#collapseInfoDetalle').hasClass('collapse')) {
                //                $(this).toggleClass('padding-responsive-margin-content');
            }
        }
    } catch (error) {
        console.log(error);
    }
});
//Método para desplegar detalles del cliente
function collapseInteraccionesCliente() {
    try {
        esconderDetalleById('ultimas24h');
        esconderDetalleById('ultimos7d');
        esconderDetalleById('ultimos30d');
        collapsedPanelById('collapseInfoDetalleCliente');
    } catch (error) {
        console.log(error);
    }
}

function filtrarSinId() {
    try {
        var input, filter, table, tr, td, tds, i, k, c;
        input = document.getElementsByClassName("filtro");
        filter = input[0].value.toUpperCase();
        table = document.getElementsByClassName("table-borderless");
        c = -1;
        tr = table[0].getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            tds = tr[i].getElementsByTagName("td");
            for (k = 1; k < tds.length; k++) {
                if (c < 0 || k === c) {
                    td = tds[k];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            c = k;
                            break;
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        }
    } catch (error) {
        console.log(error);
    }
}

function filtrarConIndices(posFilter, posTable) {
    try {
        var input, filter, table, tr, td, tds, i, k, c;
        input = document.getElementsByClassName("filtro");
        filter = input[posFilter].value.toUpperCase();
        table = document.getElementsByClassName("table-borderless");
        c = -1;
        tr = table[posTable].getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            tds = tr[i].getElementsByTagName("td");
            for (k = 1; k < tds.length; k++) {
                if (c < 0 || k === c) {
                    td = tds[k];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            c = k;
                            break;
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        }
    } catch (error) {
        console.log(error);
    }
}

function filter(idTable, idInput) {
    try {
        $(document).ready(function () {
            $("#" + idInput.toString()).on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#" + idTable.toString() + "_data tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
    } catch (error) {
        console.log(error);
    }
}

function loadBanner() {
    try {
        document.getElementById('loadBanner').click();
    } catch (error) {
        console.log(error);
    }
}

//Función para mostrar y ocultar el icono de password
$('#show_password').on('change', function (event) {
    try {
        // Si el checkbox está "checkeado"
        if ($('#show_password').is(':checked')) {
            // Convertimos el input de contraseña a texto.
            $('#password').get(0).type = 'text';
            $('#iconPassNotView').show();
            $('#iconPassView').hide();
        } else {
            // Lo convertimos a contraseña.
            $('#password').get(0).type = 'password';
            $('#iconPassNotView').hide();
            $('#iconPassView').show();
        }
    } catch (error) {
        console.log(error);
    }
});
// Método que cambia el favicon de acuerdo al ambiente desplegado


function soloLetrasNombreCampo(e) {
    try {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toLowerCase();
        letras = "abcdefghijklmnopqrstuvwxyz";
        especiales = [8, 95];
        tecla_especial = false;
        for (var i in especiales) {
            if (key === especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) === -1 && !tecla_especial) {
            return false;
        }
    } catch (error) {
        console.log(error);
    }
}

function soloLetrasNumerosBarraPisoNombreCampo(e) {
    try {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toLowerCase();
        letras = "abcdefghijklmnopqrstuvwxyz1234567890_";
        especiales = [8, 95];
        tecla_especial = false;
        for (var i in especiales) {
            if (key === especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) === -1 && !tecla_especial) {
            return false;
        }
    } catch (error) {
        console.log(error);
    }
}

function cerrarModalCargues() {
    try {
        $(".containerModalCargue").fadeOut("slow",
                function () {
                    $(".containerModalCargue").removeClass("show");
                    if (!$(".containerModalCargue").hasClass("displayNone")) {
                        $(".containerModalCargue").addClass("displayNone");
                    }

                    if (!$(".modal-backdrop").hasClass("displayNone")) {
                        $(".modal-backdrop").addClass("displayNone");
                    }

                    if ($(".containerModalCargue").hasClass("displayBlock")) {
                        $(".containerModalCargue").removeClass("displayBlock");
                    }
                    $(".modal-backdrop").removeClass("show");
                });
        opacarBacks();
    } catch (error) {
        console.log(error);
    }
}

function opacarBacks() {
    try {
        setTimeout(function () {
            var popup = $(".modal-backdrop");
            var popupStatic = $(".modal-backdrop-static");
            var i;
            for (i = 0; i < popup.length; i++) {
                if (!popup[i].classList.contains("displayNone")) {
                    popup[i].classList.add("displayNone");
                }
            }

            var j;
            for (j = 0; j < popupStatic.length; j++) {
                if (!popupStatic[j].classList.contains("displayNone")) {
                    popupStatic[j].classList.add("displayNone");
                }
            }
        }, 500);
    } catch (error) {
        console.log(error);
    }
}

function datePicker() {
    $(function () {
        $("#datepickerIni").datepicker({});
        $("#datepickerFin").datepicker({});
    });
}


function nobackbutton() {
    try {
        window.location.hash = "no-back-button";
        window.location.hash = "Again-No-back-button" //chrome
        window.onhashchange = function () {
            window.location.hash = "no-back-button";
        }
    } catch (error) {
        console.log(error);
    }
}


// Método que muestra el tab activo
function mostrarTabActivo(id) {
    try {
        $('#pnlSegmentosResponsive > section').removeClass('is-active');
        $('.mdl-layout__tab').removeClass('is-active');
        if (!$('#' + id).hasClass('is-active')) {
            $('#' + id).addClass('is-active');
        }
        if (!$('#' + id + '-btn').hasClass('is-active')) {
            $('#' + id + '-btn').addClass('is-active');
        }
    } catch (error) {
        console.log(error);
    }
}

// Método para seleccionar cuenta en responsive
function cargarCuentaMovil(idTabActivo) {
    try {
        localStorage.setItem("idTabActivo", idTabActivo);
        mostrarBloqueo('loadResponsiveInfoCliente');
        var lineaCuenta = $('.select2-results__option--highlighted')[0].innerText;
        $($(".infoCuenta-detalle-texto").filter(":contains('" + lineaCuenta + "')"))[0].click();
    } catch (error) {
        console.log(error);
    }
}

// Método para poner menú fijo en responsive
function limiterResponsive() {
    try {
        $('body').toggleClass('overflow-hidden');
    } catch (error) {
        console.log(error);
    }
}

// Método para ver menú responsive
function verMenu() {
    try {
        $('#fondoMenuResp').toggle();
        $('#tituloMenuMovil').toggle();
        $('#pnlPrincipalPages').toggleClass('positionFixed');
    } catch (error) {
        console.log(error);
    }
}

$(document).on('keyup change ', function (e) {
    try {
        var cat = $("#idListaCategoria").val();
        var com = $("#idModalTexArea").val();
        var sub = $("#idListaSubCategoria").val();
        var codigo = $("#idListaCodigoCierre").val();
        var voz = $("#idListaVozCliente").val();

        if (cat === "" || com === "" || sub === "" || codigo === "" || voz === "") {
            $("#idBtnEnviar").attr("disabled", "true");
        } else {
            $("#idBtnEnviar").removeAttr("disabled");
        }
    } catch (error) {
        console.log(error);
    }
});

// Método para limpiar form
function limpiarForm() {
    try {
        $("#idBtnEnviar").attr("disabled", "true");
    } catch (error) {
        console.log(error);
    }
}

// Método para cargar el estado
function cargarEstado(estado, contador) {
    try {
        document.getElementById('tituloEstadoPost' + contador).innerHTML = "Estado";
        document.getElementById('estadoPost' + contador).innerHTML = estado;
    } catch (error) {
        console.log(error);
    }
}

// Método para ver menú responsive
function refrescarIframe(id) {
    try {
        var iframe = document.getElementById(id);
        iframe.style.display = "none";
        iframe.src += '';
        iframe.style.display = "block";
    } catch (error) {
        console.log(error);
    }
}

// Método para presionar botón al dar enter por id y llama la funcion soloNumeros internamente
function pulsarEnterPorIdSoloNumeros(e, id) {
    try {
        if (e.which === 13) {
            pulsarClickPorId(id)
        } else {
            soloNumeros(e);
        }
    } catch (error) {
        console.log(error);
    }
}

// Método para presionar botón al dar enter por id
function pulsarEnterPorId(e, id) {
    try {
        if (e.which === 13) {
            pulsarClickPorId(id)
        }
    } catch (error) {
        console.log(error);
    }
}

function formattStringToJSON(message) {
    var toJson = JSON.parse(message);
    return JSON.stringify(toJson, null, "\t");
}

function setActiveTab(id) {
    if (!$('#' + id).hasClass('active')) {
        $('#' + id).addClass('active');
    }
}

// Método para presionar botón al dar enter por id
function mostrarMultiExcepciones() {
    try {
        $('#modalOverLoadMultipleException').show();
        $('.carousel').flickity();
    } catch (error) {
        console.log(error);
    }
}

function muestra_oculta(id) {
    try {
        var elemento = document.getElementById(id);
        if (typeof elemento !== 'undefined' && elemento !== 'null' && elemento !== null) {
            elemento.style.display = (elemento.style.display === 'none') ? 'block' : 'none';
        }
    } catch (error) {
        console.log(error);
    }
}

function toggleMultiExcepcion(id) {
    try {
        var panelMultiExc$ = $('#panelMultiExc' + id);
        var expandMoreME = $('#expandMoreME');
        var expandLessME = $('#expandLessME');

        if (typeof panelMultiExc$ !== 'undefined' && panelMultiExc$ !== 'null' && panelMultiExc$ !== null) {
            $(panelMultiExc$).toggle();
        }
        if (typeof expandMoreME !== 'undefined' && expandMoreME !== 'null' && expandMoreME !== null) {
            $(expandMoreME).toggle();
        }

        if (typeof expandLessME !== 'undefined' && expandLessME !== 'null' && expandLessME !== null) {
            $(expandLessME).toggle();
        }
    } catch (error) {
        console.log(error);
    }
}

function collapseProductosHogar(id) {
    try {
        esconderDetalleFacturacionById('divCabeceraFacturacionHogar');
        muestra_oculta(id)
    } catch (error) {
        console.log(error);
    }
}

function showMenuLateral() {
    try {
        hideItemMenuLateral('menuItem0');
        showItemMenuLateral('menuItem1');
    } catch (error) {
        console.log(error);
    }
}

function hideMenuLateral() {
    try {
        showItemMenuLateral('menuItem0');
        hideItemMenuLateral('menuItem1');
    } catch (error) {
        console.log(error);
    }
}

function showItemMenuLateral(id) {
    try {
        if ($('#' + id).hasClass("displayNone")) {
            $('#' + id).removeClass('displayNone');
        }
    } catch (error) {
        console.log(error);
    }
}

function hideItemMenuLateral(id) {
    try {
        if (!$('#' + id).hasClass("displayNone")) {
            $('#' + id).addClass('displayNone');
        }
    } catch (error) {
        console.log(error);
    }
}

function showOrHideQdnNoInfo(idFather, idCodeLabel, idCodeText, idDescLabel, idDescText) {
    try {
        if ($('#' + idFather).hasClass("qdn-show-more")) {
            $('#' + idFather).removeClass('qdn-show-more');
            $('#' + idFather).addClass('qdn-show-less');
            if ($('#' + idCodeLabel).hasClass("displayNone")) {
                $('#' + idCodeLabel).removeClass('displayNone');
            }
            if ($('#' + idCodeText).hasClass("displayNone")) {
                $('#' + idCodeText).removeClass('displayNone');
            }
            if ($('#' + idDescLabel).hasClass("displayNone")) {
                $('#' + idDescLabel).removeClass('displayNone');
            }
            if ($('#' + idDescText).hasClass("displayNone")) {
                $('#' + idDescText).removeClass('displayNone');
            }
        } else if ($('#' + idFather).hasClass("qdn-show-less")) {
            $('#' + idFather).removeClass('qdn-show-less');
            $('#' + idFather).addClass('qdn-show-more');
            if (!$('#' + idCodeLabel).hasClass("displayNone")) {
                $('#' + idCodeLabel).addClass('displayNone');
            }
            if (!$('#' + idCodeText).hasClass("displayNone")) {
                $('#' + idCodeText).addClass('displayNone');
            }
            if (!$('#' + idDescLabel).hasClass("displayNone")) {
                $('#' + idDescLabel).addClass('displayNone');
            }
            if (!$('#' + idDescText).hasClass("displayNone")) {
                $('#' + idDescText).addClass('displayNone');
            }
        }
    } catch (error) {
        console.log(error);
    }
}

// Función para desplegar el collapse de facturación y cargar el carousel interno de pagos
function collapsedPanelSelectFacturacionPostpago(contadorPost) {
    try {
        collapsedPanelSelect('divFacturacionCuentaPostpago' + contadorPost, 'cabeceraPostt' + contadorPost, 'divFacturacionPostpago');
        cargarCarousels();
    } catch (error) {
        console.log(error);
    }
}

// Función para desplegar el collapse de facturación y cargar el carousel interno de pagos
function collapsedPanelSelectFacturacionHogar(contadorPost) {
    try {
        collapsedPanelSelect('divFacturacionCuentaHogar' + contadorPost, 'cabeceraHogarr' + contadorPost, 'divFacturacionHogarHisto');
        cargarCarousels();
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del producto
function collapseInspiraRetencion(hideDiv, showDiv) {
    try {
        esconderDetalleFacturacionById(hideDiv);
        collapsedPanelById(showDiv);
    } catch (error) {
        console.log(error);
    }
}

//Método para eliminar un elemento
function removeInspiraRetencion(sendElement) {
    try {
        var elem = document.getElementById(sendElement);
        if (elem != null && elem != 'undefined') {
            elem.remove();
        }
    } catch (error) {
        console.log(error);
    }
}

//Método para desplegar detalles del producto
function collapseInspiraFidelizacion(hideDiv, showDiv) {
    try {
        esconderDetalleFacturacionById(hideDiv);
        collapsedPanelById(showDiv);
    } catch (error) {
        console.log(error);
    }
}

function hideItemById(id) {
    try {
        if (!$('#' + id).hasClass("displayNone")) {
            $('#' + id).addClass('displayNone');
        }
    } catch (error) {
        console.log(error);
    }
}

function eliminarCookies() {
    try {
        document.cookie = "bandera=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    } catch (error) {
        console.log(error);
    }
}

function collapsePanelHogar(showMenu, hideMenu) {
    try {
        esconderDetalleFacturacionById(hideMenu);
        collapsedPanelById(showMenu);
    } catch (error) {
        console.log(error);
    }
}


function closemodalNotificationServlet() {
    try {
        var modal = document.getElementById("modalOverLoadNotificationServlet");
        $('#btnLoadModalNotificationServlet').click();
        $(modal).removeClass('displayBlock');
        $(modal).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}


$(document).ready(function () {
    try {
        var modal = document.getElementById("modalOverLoadNotificationServlet");
        $('#btnLoadModalNotificationServlet').click();
        if ($(modal).hasClass("displayNone")) {
            $(modal).removeClass('displayNone');
            $(modal).addClass('displayBlock');
        } else {
            $(modal).addClass('displayNone');
            $(modal).removeClass('displayBlock');
        }
    } catch (error) {
        console.log(error);
    }
});

function closeModalAccionAgenda() {
    try {
        var modal = document.getElementById("modalOverLoadAccionAgenda");
        $('#btnLoadModalAccionAgenda').click();
        $(modal).removeClass('displayBlock');
        $(modal).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function modalAccionAgenda() {
    try {
        var modal = document.getElementById("modalOverLoadAccionAgenda");
        $('#btnLoadModalAccionAgenda').click();
        if ($(modal).hasClass("displayNone")) {
            $(modal).removeClass('displayNone');
            $(modal).addClass('displayBlock');
        } else {
            $(modal).addClass('displayNone');
            $(modal).removeClass('displayBlock');
        }
    } catch (error) {
        console.log(error);
    }
}

function loadModal() {
    try {
        var modal = document.getElementById("modalOverLoadNotificationCommand");
        if ($(modal).hasClass("displayNone")) {
            $(modal).removeClass('displayNone');
            $(modal).addClass('displayBlock');
        } else {
            $(modal).addClass('displayNone');
            $(modal).removeClass('displayBlock');
        }
    } catch (error) {
        console.log(error);
    }
}

function closeModal() {
    try {
        var modal = document.getElementById("modalOverLoadNotificationCommand");
        $(modal).removeClass('displayBlock');
        $(modal).addClass('displayNone');
    } catch (error) {
        console.log(error);
    }
}

function changePage(urReturn) {
    window.top.location.replace(urReturn);
}
function reloadPage() {
    location.reload();
}