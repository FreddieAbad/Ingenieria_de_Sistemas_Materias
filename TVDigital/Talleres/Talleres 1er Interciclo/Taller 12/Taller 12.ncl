<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="38.96%" id="region1" left="9.95%" top="10.00%" width="79.98%" zIndex="2">
					<region height="48.66%" id="region2" left="48.76%" top="43.32%" width="49.19%" zIndex="3">
					</region>
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="d1" region="region1">
			</descriptor>
			<descriptor focusIndex="1" id="d2" region="region2">
			</descriptor>
			<descriptor id="d3" region="region2">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="d1" id="m0" src="texto.lua">
		</media>
		<port component="m0" id="p0">
		</port>
		<media id="m1" type="application/x-ginga-settings">
			<property name="service.currentKeyMaster" value="1">
			</property>
		</media>
		<media descriptor="d2" id="m2" src="Eventos.lua">
		</media>
		<port component="m2" id="p1">
		</port>
	</body>
</ncl>
