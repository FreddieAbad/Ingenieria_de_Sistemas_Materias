<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="28.96%" id="region1" left="9.95%" top="10.00%" width="54.68%" zIndex="2">
				</region>
				<region height="45.00%" id="region2" left="4.92%" top="47.71%" width="79.98%" zIndex="3">
				</region>
				<region height="27.08%" id="region3" left="69.32%" top="10.00%" width="20.61%" zIndex="4">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dC" region="region1">
			</descriptor>
			<descriptor id="dI" region="region2">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dC" id="m0" src="texto.lua">
		</media>
		<port component="m0" id="p0">
		</port>
		<media descriptor="dI" id="m2" src="cont.lua">
		</media>
		<port component="m2" id="p2">
		</port>
	</body>
</ncl>
