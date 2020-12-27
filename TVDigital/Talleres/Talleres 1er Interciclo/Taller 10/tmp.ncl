<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
			<causalConnector id="onKeySelectionSSS">
				<simpleCondition key="$keyCode" role="onSelection">
				</simpleCondition>
				<connectorParam name="keyCode">
				</connectorParam>
				<connectorParam name="var">
				</connectorParam>
				<compoundAction operator="seq">
					<simpleAction role="stop">
					</simpleAction>
					<simpleAction max="unbounded" role="set" value="$var">
					</simpleAction>
					<simpleAction role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="imagen" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
			</region>
			<region bottom="0.00%" height="100.00%" id="video" left="0.00%" right="0.00%" top="0.00%" width="100.00%" zIndex="4">
			</region>
			<region bottom="0.62%" height="13.54%" id="boton" left="84.19%" right="0.00%" top="85.83%" width="15.81%" zIndex="5">
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dV" region="video">
			</descriptor>
			<descriptor id="dI" region="video">
			</descriptor>
			<descriptor id="dB" region="boton">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media id="video1" src="../Marzo 2017 - Julio 2017/Op 14 TV Digital/Talleres 1er Interciclo/Taller 10 - TV DIGITAL/Media/2.mp4">
			<property name="bounds" value="0.00%,0.00%,100.00%,100.00%">
			</property>
		</media>
		<media id="m1" src="../Marzo 2017 - Julio 2017/Op 14 TV Digital/Talleres 1er Interciclo/Taller 10 - TV DIGITAL/Media/p2 (1).png">
		</media>
		<media id="m2" src="../Marzo 2017 - Julio 2017/Op 14 TV Digital/Talleres 1er Interciclo/Taller 10 - TV DIGITAL/Media/p2 (1).png">
		</media>
		<port component="video1" id="p0">
		</port>
		<port component="m2" id="p1">
		</port>
		<link id="l0" xconnector="onKeySelectionSSS">
			<linkParam name="keyCode" value="RED">
			</linkParam>
			<bind component="video1" role="onSelection">
			</bind>
			<bind component="video1" role="stop">
			</bind>
			<bind component="video1" interface="bounds" role="set">
				<bindParam name="var" value="10.00%,20.00%,40.00%,40.00%">
				</bindParam>
			</bind>
			<bind component="video1" role="start">
			</bind>
		</link>
		<link id="L1" xconnector="onKeySelectionSSS">
			<linkParam name="keyCode" value="BLUE">
			</linkParam>
			<bind component="video1" role="onSelection">
			</bind>
			<bind component="video1" role="stop">
			</bind>
			<bind component="video1" interface="bounds" role="set">
				<bindParam name="var" value="0.00%,0.00%,100.00%,100.00%">
				</bindParam>
			</bind>
			<bind component="video1" role="start">
			</bind>
		</link>
		<port component="m1" id="p2">
		</port>
	</body>
</ncl>
