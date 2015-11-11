<jsp:useBean id="perfil" class="es.rotolearn.javaBean.RegistroBean" scope="session"/>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>C&aacute;talogo de cursos</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./style/plantilla.css" media="screen"/>
    <link href="style/catalogo.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Merriweather+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="./style/footer.css" media="screen"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

		<!-- The JavaScript -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <script type="text/javascript">
            $(function() {

				var $ui = $('#ui_element');
				

				$ui.find('.sb_input').bind('focus click',function(){
					$ui.find('.sb_down')
					   .addClass('sb_up')
					   .removeClass('sb_down')
					   .andSelf()
					   .find('.sb_dropdown')
					   .show();
				});
				

				$ui.bind('mouseleave',function(){
					$ui.find('.sb_up')
					   .addClass('sb_down')
					   .removeClass('sb_up')
					   .andSelf()
					   .find('.sb_dropdown')
					   .hide();
				});
				

				$ui.find('.sb_dropdown').find('label[for="all"]').prev().bind('click',function(){
					$(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
				});
            });
        </script>	
  
</head>
<body>

    	<!--CABECERA-->
       <header>
        <div class="container-fluid">
        	<nav id="menu" class="navbar navbar-default">
            	<div class="navbar-header">
                	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    	<span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                	<img class="navbar-brand logotipo" src="./images/logo.png">
				</div>
                <div class="collapse navbar-collapse" id="myNavbar">
                	<ul class="nav navbar-nav">
                    	<li><a href="index.jsp">Inicio</a></li>
                        <!--<li><a href="perfil.jsp">Mi perfil</a></li>-->
                        <li><a class="activa" href="catalogo.jsp">Cat&aacute;logo de cursos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        
                        <%
			            	if(session.getAttribute("usuario") == null){
						%>
                        <!-- NO REGISTRADO -->
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>Inicia sesi&oacute;n</a></li>
                        <li><a href="formulario_registro.jsp"><span class="glyphicon glyphicon-user"></span>Registrate</a></li>
                        <%
                        	}else{ 
                        %>
                        <!-- REGISTRADO -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span> <%=session.getAttribute("usuario")%> <img src="./images/perfil/anonimo.jpeg" class="img-circle" alt="Cinque Terre" width="30" height="30"/></a>
                            <ul class="dropdown-menu">
                                <li><a href="perfil.jsp"><span class="glyphicon glyphicon-user"></span>Mi perfil</a></li>
                                <% if(!perfil.getTipo().equals("alumn")){%>
                                <li><a href="profes_panel.jsp"><span class="glyphicon glyphicon-th-large"></span>Panel de Control</a></li>
                                <% }%> 
                                <li><a href="logout.form"><span class="glyphicon glyphicon-remove-sign"></span>Cerrar sesi&oacute;n</a></li>
                            </ul>
                        </li>
                        <%
                        	}
                        %>
                    </ul>
                </div>
            </nav>
        </div>
    </header>
    <!--FIN CABECERA-->
    <div class="container-fluid">
	    <div class="row" id="buscador">
            <div class="col-md-12">
                <form class="field" id="searchform" action="#">
                    <input type="text" id="searchterm" placeholder="Encuentra el curso que buscas" />
                    <button type="submit" id="search" value="submit">Buscar</button>
                </form>
            </div>
        </div>
    </div>
    <div class="container-fluid">
	    <div class="row" id="cuerpo">
            <div class="col-md-12">
                <ul class="portfolio-items">
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="https://tpc.googlesyndication.com/simgad/15583114969609929571" alt="">
                            <h5>Curso de iniciaci&oacute;n a la inform&aacute;tica</h5>
                            <h1 class="precios"><span class="precio">75$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item1.jpg" alt="">
                            <h5>Las Redes Sociales y los CEO</h5>
                            <h1 class="precios"><span class="precio">70$</span><span class="precioAntiguo">90$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item2.jpg" alt="">
                            <h5>Instagram:descubre sus secretos.</h5>
                            <h1 class="precios"><span class="precio">30$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item3.jpg" alt="">
                            <h5>La verdad sobre Twitter: como ser un influencer</h5>
                            <h1 class="precios"><span class="precio">80$</span><span class="precioAntiguo">200$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item4.jpg" alt="">
                            <h5>La Historia y la infor&aacute;tica</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item5.jpg" alt="">
                            <h5>La influencia de las guerras en las RRSS</h5>
                            <h1 class="precios"><span class="precio">10$</span><span class="precioAntiguo">40$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item6.jpg" alt="">
                            <h5>Arduino for dummies</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item7.jpg" alt="">
                            <h5>Crea tu propio microrobot</h5>
                            <h1 class="precios"><span class="precio">60$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item2.jpg" alt="">
                            <h5>Conviertete en un villano de pel&iacute;cula</h5>
                            <h1 class="precios"><span class="precio">1000$</span><span class="precioAntiguo">3000$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item7.jpg" alt="">
                            <h5>Como encontrar m&aacute;s ideas para t&iacute;tulos de cursos</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item5.jpg" alt="">
                            <h5>Por qu&eacute; me he quedado sin ideas</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item2.jpg" alt="">
                            <h5>Ayuda personal para aprobar pr&aacute;cticas</h5>
                            <h1 class="precios"><span class="precio">700$</span><span class="precioAntiguo">1000$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item3.jpg" alt="">
                            <h5>League of Legends o como suspender</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item4.jpg" alt="">
                            <h5>MUSE: el nacimiento de una leyenda</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                    <li class="portfolio-item col-md-2">
                        <div class="itemCatalogo">
                            <img src="images/portfolio/thumb/item5.jpg" alt="">
                            <h5>Como terminar al fin con el cat&aacute;logo</h5>
                            <h1 class="precios"><span class="precio">50$</span><span class="precioAntiguo">100$</span></h1>
                            <div class="overlay">
                                <a class="preview glyphicon glyphicon-shopping-cart" href="#" rel="prettyPhoto"><br><span>Comprar</span></a>
                                <a class="preview glyphicon glyphicon-eye-open" href="info_curso.jsp" rel="prettyPhoto"><br><span>Ver</span></a>
                            </div>           
                        </div>           
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid">
	    <div class="row">
	        <div class="col-md-7 col-md-offset-5">
    	        <ul class="pagination">
                        <li><a href="#">Primero</a></li>
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">&raquo;</a></li>
                        <li><a href="#">&Uacute;ltimo</a></li>
                </ul>
            </div>
        </div>
    </div>
        <!--PIE DE PAGINA-->
        <footer>
	    <div class="container-fluid" id="pie">
	    	<div class="row">
	    		<div class="col-md-3 col-md-offset-1" id="footer-left">
	    			<img class="logotipo img-responsive" src="./images/logo.png">
	                <p class="footer-links">
	    				<a href="index.jsp">Home</a> &#45;
	    				<a href="https://www.forocoches.com/">Faq</a> &#45;
	    				<a href="#">Contact</a>
	    			</p>
	    			<p class="footer-company-name">Roto2 Company &copy; 2015</p>
	    		</div>
	    		<div class="col-md-3 col-md-offset-1" id="footer-center">
	    			<div>
	    				<i class="fa fa-map-marker"></i>
	    				<p><span>6 Calle Jaime Balmes</span> Le&oacute;n, Castilla y Le&oacute;n</p>
	    			</div>
	    			<div>
	    				<i class="fa fa-phone"></i>
	    				<p>+34 288 288 288</p>
	    			</div>
	    			<div>
	    				<i class="fa fa-envelope"></i>
	    				<p><a href="mailto:support@rotolearn.com">support@rotolearn.com</a></p>
	    			</div>
	    		</div>
	    		<div class="col-md-3 col-md-offset-1" id="footer-right">
	    			<p class="footer-company-about">
	    				<span>Sobre la compa&ntilde;ia</span>
	    				Roto2 Company lleva afincada en el sector del software desde que Ilitri fund&oacute; un equipo lleno de peque&ntilde;os troles y ni&ntilde;os ratas. 
	    			</p>
	    			<div class="footer-icons">
	    				<a href="#"><i class="fa fa-facebook"></i></a>
	    				<a href="#"><i class="fa fa-twitter"></i></a>
	    				<a href="#"><i class="fa fa-linkedin"></i></a>
	    				<a href="#"><i class="fa fa-github"></i></a>
	    			</div>
	    		</div>
	    	</div>
	    </div>
	    </footer>
        <!--FIN PIE DE PAGINA-->

</body>
</html>