<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="23.54%" id="region1" left="6.44%" top="8.54%" width="45.43%" zIndex="2">
				</region>
				<region height="80.83%" id="region3" left="54.22%" top="8.75%" width="43.09%" zIndex="4">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dTitle" region="region1">
			</descriptor>
			<descriptor id="dConexion" region="region3">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dTitle" id="m0" src="texto.lua">
		</media>
		<media descriptor="dConexion" id="m1" src="ejemploTCP.lua">
		</media>
		<port component="m0" id="p1">
		</port>
		<port component="m1" id="p2">
		</port>
	</body>
</ncl>
