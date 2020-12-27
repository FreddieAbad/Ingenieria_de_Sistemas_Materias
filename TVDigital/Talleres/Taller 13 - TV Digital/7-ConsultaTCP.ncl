<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Muestra el contenido generado al utilizar el modulo canvas de lua
para mostrar texto-->
<ncl id="canvas" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<regionBase>
			<region id="reg" width="100%" height="100%" left="0%" top="0%" />
		</regionBase>
		<descriptorBase>
			<descriptor id="desc" region="reg"/>
		</descriptorBase>
	</head>
	<body>
		<port id="pLua" component="lua" />
		<media id="lua" src="7-ConsultaTCP.lua" descriptor="desc" />
	</body>
</ncl>

