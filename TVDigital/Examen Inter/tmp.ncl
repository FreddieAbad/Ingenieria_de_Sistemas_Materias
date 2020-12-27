<ncl id="myNCLDocID">
	<head>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="100.00%" id="region1" left="0.00%" top="0.00%" width="100.00%" zIndex="2">
					<region height="26.46%" id="region2" left="71.19%" top="55.83%" width="21.19%" zIndex="2">
					</region>
					<region height="95.83%" id="region3" left="0.00%" top="0.00%" width="100.00%" zIndex="3">
						<region height="9.35%" id="region4" left="8.67%" top="4.78%" width="17.68%" zIndex="3">
						</region>
						<region height="8.91%" id="region5" left="8.55%" top="42.39%" width="17.68%" zIndex="3">
						</region>
						<region height="8.48%" id="region6" left="8.55%" top="17.39%" width="17.80%" zIndex="3">
						</region>
						<region height="8.26%" id="region7" left="8.43%" top="29.78%" width="17.92%" zIndex="3">
						</region>
						<region height="11.52%" id="region8" left="9.95%" top="78.48%" width="22.25%" zIndex="4">
						</region>
						<region height="11.52%" id="region9" left="35.25%" top="78.04%" width="25.29%" zIndex="5">
						</region>
						<region height="11.96%" id="region10" left="65.57%" top="78.04%" width="24.36%" zIndex="6">
						</region>
					</region>
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor freeze="true" id="dIMP" region="region1">
			</descriptor>
			<descriptor freeze="true" id="dBIMP" region="region2">
			</descriptor>
			<descriptor id="dfM2" region="region3">
			</descriptor>
			<descriptor focusIndex="1" focusSrc="menu1On.png" id="d1M2" moveDown="2" moveUp="4" region="region4">
			</descriptor>
			<descriptor focusIndex="2" focusSrc="menu2On.png" id="d2M2" moveDown="3" moveUp="1" region="region5">
			</descriptor>
			<descriptor focusIndex="3" focusSrc="menu3On.png" id="d3M2" moveDown="4" moveUp="2" region="region6">
			</descriptor>
			<descriptor focusIndex="4" focusSrc="menu4On.png" id="d4M2" moveDown="1" moveUp="3" region="region7">
			</descriptor>
			<descriptor id="dVM3" region="region3">
			</descriptor>
			<descriptor id="dTM1" region="region8">
			</descriptor>
			<descriptor id="dTM2" region="region9">
			</descriptor>
			<descriptor id="dTM3" region="region10">
			</descriptor>
		</descriptorBase>
		<connectorBase id="connectorBase1">
			<importBase alias="conectores" documentURI="libreriaConector.ncl">
			</importBase>
		</connectorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dIMP" id="imgmenuInicial" src="videoPrincipal.mp4">
		</media>
		<media descriptor="dBIMP" id="btnMenuPrincipal" src="interactividad.png">
			<property name="transparency" value="0.015">
			</property>
			<property name="focusIndex" value="3">
			</property>
		</media>
		<port component="imgmenuInicial" id="p0">
		</port>
		<link id="l0" xconnector="conectores#onBeginStart">
			<bind component="imgmenuInicial" role="onBegin">
			</bind>
			<bind component="btnMenuPrincipal" role="start">
			</bind>
		</link>
		<media descriptor="d1M2" id="m0M2" src="menu1.png">
		</media>
		<media descriptor="d2M2" id="m1M2" src="menu2.png">
		</media>
		<media descriptor="d3M2" id="m2M2" src="menu3.png">
		</media>
		<media descriptor="d4M2" id="m3M2" src="menu4.png">
		</media>
		<media descriptor="dfM2" id="fondoM2" src="fondoMenu.png">
		</media>
		<link id="l1" xconnector="conectores#onKeySelectionBlue">
			<bind component="imgmenuInicial" role="onSelection">
			</bind>
			<bind component="imgmenuInicial" role="stop">
			</bind>
			<bind component="btnMenuPrincipal" role="stop">
			</bind>
			<bind component="fondoM2" role="start">
			</bind>
			<bind component="m0M2" role="start">
			</bind>
			<bind component="m1M2" role="start">
			</bind>
			<bind component="m2M2" role="start">
			</bind>
			<bind component="m3M2" role="start">
			</bind>
		</link>
		<media descriptor="dVM3" id="m0M3" src="reportaje.mp4">
		</media>
		<media descriptor="dTM2" id="texto1" src="descripcion01.txt">
			<area begin="3s" end="6s" id="duracion">
			</area>
		</media>
		<media descriptor="dTM1" id="texto2" src="descripcion02.txt">
			<area begin="6s" end="9s" id="duracion2">
			</area>
		</media>
		<media descriptor="dTM3" id="texto3" src="descripcion03.txt">
			<area begin="9s" end="12s" id="duracion3">
			</area>
		</media>
		<link id="l2" xconnector="conectores#onKeySelectionEnter">
			<bind component="m0M2" role="onSelection">
			</bind>
			<bind component="m2M2" role="stop">
			</bind>
			<bind component="m3M2" role="stop">
			</bind>
			<bind component="m0M2" role="stop">
			</bind>
			<bind component="m1M2" role="stop">
			</bind>
			<bind component="fondoM2" role="stop">
			</bind>
			<bind component="m0M3" role="start">
			</bind>
			<bind component="texto1" role="start">
			</bind>
			<bind component="texto2" role="start">
			</bind>
			<bind component="texto3" role="start">
			</bind>
		</link>
		<link id="l3" xconnector="conectores#onEndStart">
			<bind component="m0M3" role="onEnd">
			</bind>
			<bind component="imgmenuInicial" role="start">
			</bind>
		</link>
		<link id="l4" xconnector="conectores#onEndStart">
			<bind component="m0M3" role="onEnd">
			</bind>
			<bind component="btnMenuPrincipal" role="start">
			</bind>
		</link>
	</body>
</ncl>
