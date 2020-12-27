<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
			</region>
			<region height="100.00%" id="region1" left="69.91%" top="0.00%" width="30.09%" zIndex="2">
				<region height="34.24%" id="region2" left="10.12%" top="3.99%" width="80.16%" zIndex="3">
				</region>
				<region height="28.12%" id="region3" left="15.56%" top="49.38%" width="80.16%" zIndex="4">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="descriptor0" region="region0" transIn="trans">
			</descriptor>
			<descriptor explicitDur="10s" id="descriptor1" region="region1" transIn="trans">
			</descriptor>
			<descriptor explicitDur="8s" id="descriptor2" region="region2" transIn="trans">
			</descriptor>
			<descriptor explicitDur="6s" id="descriptor3" region="region3" transIn="trans">
				<descriptorParam name="fontColor" value="yellow">
				</descriptorParam>
				<descriptorParam name="fontSize" value="20">
				</descriptorParam>
				<descriptorParam name="fontType" value="Georgia">
				</descriptorParam>
			</descriptor>
		</descriptorBase>
		<transitionBase id="transitionBase1">
			<transition dur="4s" id="trans" type="fade">
			</transition>
		</transitionBase>
	</head>
	<body id="myBodyID">
		<media descriptor="descriptor0" id="m0" src="VID_71150429_225355_486.mp4">
		</media>
		<media descriptor="descriptor1" id="m1" src="blue.jpg">
			<property name="transparency" value="50%">
			</property>
		</media>
		<port component="m0" id="p0">
		</port>
		<port component="m1" id="p1">
		</port>
		<media descriptor="descriptor2" id="m2" src="imagenTaller2TVD.png">
		</media>
		<media descriptor="descriptor3" id="m3" src="textoTaller2TVD.txt">
		</media>
		<port component="m2" id="p2">
		</port>
		<port component="m3" id="p3">
		</port>
	</body>
</ncl>
