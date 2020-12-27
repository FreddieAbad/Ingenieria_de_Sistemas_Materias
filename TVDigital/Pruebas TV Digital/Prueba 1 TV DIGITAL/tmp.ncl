<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="connBaseId">
			<causalConnector id="startStop">
				<connectorParam name="keyCode">
				</connectorParam>
				<simpleCondition key="$keyCode" role="onSelection">
				</simpleCondition>
				<compoundAction operator="seq">
					<simpleAction max="unbounded" qualifier="par" role="start">
					</simpleAction>
					<simpleAction max="unbounded" qualifier="par" role="stop">
					</simpleAction>
				</compoundAction>
			</causalConnector>
			<causalConnector id="onEnd2">
				<compoundCondition operator="and">
					<simpleCondition max="unbounded" qualifier="and" role="onEnd">
					</simpleCondition>
				</compoundCondition>
				<simpleAction max="unbounded" qualifier="seq" role="start">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onEnd3">
				<compoundCondition operator="and">
					<simpleCondition max="unbounded" qualifier="and" role="onEnd">
					</simpleCondition>
				</compoundCondition>
				<simpleAction max="unbounded" qualifier="seq" role="stop">
				</simpleAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="20.83%" id="region1" left="9.95%" top="10.00%" width="21.19%" zIndex="2">
				</region>
				<region height="20.83%" id="region2" left="9.72%" top="37.08%" width="21.19%" zIndex="2">
				</region>
				<region height="100.00%" id="region3" left="0.12%" top="0.00%" width="99.88%" zIndex="3">
					<region height="10.00%" id="region4" left="70.46%" top="10.00%" width="19.46%" zIndex="4">
					</region>
					<region height="31.67%" id="region5" left="9.38%" top="27.08%" width="34.47%" zIndex="4">
					</region>
					<region height="31.67%" id="region6" left="50.06%" top="27.50%" width="34.47%" zIndex="4">
					</region>
					<region height="22.08%" id="region7" left="9.96%" top="61.88%" width="74.91%" zIndex="4">
					</region>
					<region height="10.00%" id="region8" left="71.98%" top="88.33%" width="19.46%" zIndex="4">
					</region>
					<region height="100.00%" id="region9" left="0.00%" top="0.00%" width="100.00%" zIndex="5">
						<region height="31.88%" id="region10" left="21.10%" top="10.00%" width="53.22%" zIndex="7">
						</region>
						<region height="15.62%" id="region11" left="9.73%" top="46.04%" width="79.95%" zIndex="7">
						</region>
						<region height="15.62%" id="region12" left="9.73%" top="62.71%" width="79.95%" zIndex="7">
						</region>
						<region height="11.25%" id="region13" left="79.13%" top="82.29%" width="12.54%" zIndex="8">
						</region>
					</region>
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="descriptor1" region="region1">
			</descriptor>
			<descriptor id="descriptor2" region="region2">
			</descriptor>
			<descriptor id="descriptor3" region="region4">
			</descriptor>
			<descriptor id="descriptor4" region="region5">
			</descriptor>
			<descriptor id="descriptor5" region="region6">
			</descriptor>
			<descriptor id="descriptor6" region="region7">
			</descriptor>
			<descriptor id="descriptor7" region="region8">
			</descriptor>
			<descriptor id="descriptor8" region="region10">
			</descriptor>
			<descriptor id="descriptor9" region="region11">
			</descriptor>
			<descriptor id="descriptor10" region="region12">
			</descriptor>
			<descriptor id="descriptor11" region="region13">
			</descriptor>
			<descriptor id="fondo">
			</descriptor>
			<descriptor id="descriptor12" region="region3">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="descriptor1" id="opcion1P1" src="../Media/opcionP1 (1).png">
		</media>
		<media descriptor="descriptor2" id="opcion2P1" src="../Media/opcionP1 (2).png">
		</media>
		<media descriptor="descriptor3" id="logoP2" src="../Media/logo.png">
			<property name="transparency" value="50%">
			</property>
		</media>
		<media descriptor="descriptor4" id="vide1P2" src="../Media/videosP2 (1).mp4">
		</media>
		<media descriptor="descriptor5" id="video2P2" src="../Media/videosP2 (1).mp4">
		</media>
		<media descriptor="descriptor6" id="textoP2" src="../Media/TEXTOP2.txt">
			<property name="fontSize" value="30">
			</property>
			<property name="fontColor" value="red">
			</property>
		</media>
		<media descriptor="descriptor7" id="flecha" src="../Media/flecha.png">
		</media>
		<port component="opcion1P1" id="p0">
		</port>
		<port component="opcion2P1" id="p1">
		</port>
		<media descriptor="descriptor12" id="fondoP2" src="../Media/fondoMenu.png">
		</media>
		<link id="l0" xconnector="startStop">
			<bind component="opcion1P1" role="onSelection">
				<bindParam name="keyCode" value="RED">
				</bindParam>
			</bind>
			<bind component="logoP2" role="start">
			</bind>
			<bind component="vide1P2" role="start">
			</bind>
			<bind component="video2P2" role="start">
			</bind>
			<bind component="fondoP2" role="start">
			</bind>
			<bind component="flecha" role="start">
			</bind>
			<bind component="opcion1P1" role="stop">
			</bind>
			<bind component="opcion2P1" role="stop">
			</bind>
		</link>
		<link id="l1" xconnector="onEnd2">
			<bind component="vide1P2" role="onEnd">
			</bind>
			<bind component="video2P2" role="onEnd">
			</bind>
			<bind component="textoP2" role="start">
			</bind>
		</link>
		<link id="l2" xconnector="onEnd3">
			<bind component="vide1P2" role="onEnd">
			</bind>
			<bind component="video2P2" role="onEnd">
			</bind>
			<bind component="logoP2" role="stop">
			</bind>
		</link>
		<link id="l3" xconnector="startStop">
			<bind component="flecha" role="onSelection">
				<bindParam name="keyCode" value="CURSOR_LEFT">
				</bindParam>
			</bind>
			<bind component="opcion1P1" role="start">
			</bind>
			<bind component="opcion2P1" role="start">
			</bind>
			<bind component="textoP2" role="stop">
			</bind>
			<bind component="vide1P2" role="stop">
			</bind>
			<bind component="video2P2" role="stop">
			</bind>
			<bind component="fondoP2" role="stop">
			</bind>
			<bind component="flecha" role="stop">
			</bind>
		</link>
		<media descriptor="descriptor8" id="audiop3" src="../Media/videosP2 (2).mp4">
			<property name="transparency" value="0.20">
			</property>
			<property name="soundLevel" value="0.4">
			</property>
			<area begin="3s" end="5s" id="texto1">
			</area>
			<area begin="6s" end="10s" id="texto2">
			</area>
		</media>
		<media descriptor="descriptor9" id="texto1p3" src="../Media/texto2p3.txt">
			<property name="fontSize" value="30">
			</property>
			<property name="fontColor" value="red">
			</property>
		</media>
		<media descriptor="descriptor10" id="texto2p3" src="../Media/texto1p3.txt">
			<property name="fontSize" value="30">
			</property>
			<property name="fontColor" value="red">
			</property>
		</media>
		<media descriptor="descriptor11" id="felchap3" src="../Media/flecha.png">
		</media>
		<link id="l4" xconnector="startStop">
			<bind component="opcion2P1" role="onSelection">
				<bindParam name="keyCode" value="BLUE">
				</bindParam>
			</bind>
			<bind component="audiop3" role="start">
			</bind>
			<bind component="texto1p3" role="start">
			</bind>
			<bind component="texto2p3" role="start">
			</bind>
			<bind component="felchap3" role="start">
			</bind>
			<bind component="opcion2P1" role="stop">
			</bind>
			<bind component="opcion1P1" role="stop">
			</bind>
		</link>
		<link id="l5" xconnector="startStop">
			<bind component="felchap3" role="onSelection">
				<bindParam name="keyCode" value="CURSOR_LEFT">
				</bindParam>
			</bind>
			<bind component="opcion1P1" role="start">
			</bind>
			<bind component="opcion2P1" role="start">
			</bind>
			<bind component="audiop3" role="stop">
			</bind>
			<bind component="texto1p3" role="stop">
			</bind>
			<bind component="texto2p3" role="stop">
			</bind>
			<bind component="felchap3" role="stop">
			</bind>
		</link>
	</body>
</ncl>
