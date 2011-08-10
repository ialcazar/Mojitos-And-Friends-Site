<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	
	<title>Mojitos and friends</title>
	<meta name="keywords" content="Aprender, compartir, divertirse, mojitos en Madrid, Amigos, Friends," >
	<meta name="description" content="Aprender, compartir, divertirse rodeados siempre de un buen Mojito" >
	<meta http-equiv="Pragma" content="no-cache" >
	<title>Mojitos and friends</title>
	<link type="text/plain" rel="author" href="humans.txt" />
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="apple-touch-icon" href="apple-touch-icon.png">
	<link rel="stylesheet" href="css/style.css?v=2">
	<link rel="stylesheet" media="handheld" href="../../css/handheld.css?v=2">
	<script src="js/libs/modernizr-1.7.min.js"></script>
</head>
<body onload="loadGMaps()" onunload="GUnload()">
	<div id="container" class="content">
		<header>
			<nav>
				<ul>
					<li class="first selected" id="li-index"><a href="#" id="lnk-index">Inicio</a></li>
					<li class="second" id="li-about"><a href="#" id="lnk-about">De qué va esto</a></li>
					
			</nav>
			<!-- LOGO twitter -->
			<section class="info">
				<a href="http://twitter.com/MojAndFriends" target="_blank"><img src="images/twitter_logo.png" class="logo_follow"/></a>
				</section>
		</header>
		
<!-- CUERPO -->
		<div id="main" role="main">
			<section id="de-que-va-esto" class="presentacion" style="display:none">
				<strong>De que va esto</strong>
				<article>
					<p>Seguimos el formato <a class="link" href="http://es.wikipedia.org/wiki/BarCamp">Barcamp</a>. Queremos que sean reuniones espontáneas con el único objetivo de compartir y aprender en un entorno abierto a tod@s. No tenemos normas de inscripción, nuestras únicas reglas son:
					</p>
					<br/>
					<p>
						<ol class="normal big indent" >
							<li>Aprende</li>
							<li>Comparte</li>
							<li>Diviértete</li>
						</ol>
					</p>
					<br/>
					<p>Cualquiera puede proponer temas. El único compromiso es que asistas ese dí­a. El lugar también puede variar, solo necesitamos un sitio donde se pueda charlar y se pueda tomar algo,ya sean mojitos o no!</p>
					<br/>
					<p>¿Tienes un proyecto en mente?¿Quieres presentarlo para recibir feedback? Adelante, estaremos encantados de escucharte. Incluso puede que encuentres a alguien que quiera ayudarte.</p>
					<br/>
					<p align="center"><b class="normal" >¿A qué esperas para participar?</b></p>
				</article>
			</section>
			<section id="proximamente" class="fechas" style="display:none">
				
				<strong>Última reunión</strong>

				<ul>
					<li>
						<span>06 / 07 / 2011</span>
						<div><strong>El Tigre</strong></div>
						<div>Calle de las Infantas,30 (Madrid)</div>
					</li>
				</ul>
			
			</section>
			<section id="attendees" class="attendees">
				<p style="text-align:left;margin-top:0;">&nbsp;</p>
			</section>
			<section id="twitts" class="twitts">
					<script src="http://widgets.twimg.com/j/2/widget.js"></script>
					<script>
					new TWTR.Widget({
					  version: 2,
					  type: 'profile',
				      search: 'mojandfriends',
					  title:'@mojAndFriends',
					  interval: 3000,
					  width: 'auto',
					  height: 300,
					  theme: {
					    shell: {
					     	background: '#088a11',
						    color: '#ffffff'
					    },
					    tweets: {
					      	background: '#ffffff',
						      color: '#45c206',
						      links: '#4e9131'
					    }
					  },
					  features: {
					    scrollbar: false,
					    loop: false,
					    live: true,
					    hashtags: true,
					    timestamp: true,
					    avatars: true,
					    behavior: 'default'
					  }
					}).render().setUser('mojandfriends').start();
					</script>
			</section>
			<section id="map2" class="map"></section>

		</div>
<!-- PIE -->
		<footer>
			<p class="left" >
				<a href="http://www.w3.org/html/logo/" target="_blank"><img src="images/ico-html5.png" class="html5" alt="Html5" width="22" height="26" /></a> 
			</p>
			<p class="center">
			Copyleft 2011 - Si no queda satisfecho, no le devolvemos su dinero :-)
			</p>
		
			<p class="right"> 
					<a href="humans.txt"><img src="images/humanstxt-transparent-color.png" alt="Humans.txt" width="80" height="25"></a>
			</p>
		</footer>
	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script>!window.jQuery && document.write(unescape('%3Cscript src="js/libs/jquery-1.6.2.min.js"%3E%3C/script%3E'))</script>
	<script src="js/plugins.js"></script>
	<script src="js/script.js"></script>
	<!--[if lt IE 7 ]>
	<script src="js/libs/dd_belatedpng.js"></script>
	<script> DD_belatedPNG.fix('img, .png_bg');</script>
	<![endif]-->
	<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=ABQIAAAABB-Ib23PFdZ5W8izjohEDBRS6K7jZmwE4ryibryC7EWVIebX6RT_hGIEYvp3edkgFE2p_gQr3Rhiyg" type="text/javascript"></script>
	<!-- GOOGLE ANALITICS-->
	<script type="text/javascript">

	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-24470728-1']);
	  _gaq.push(['_trackPageview']);

	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();

	</script>
	
</body>
</html>