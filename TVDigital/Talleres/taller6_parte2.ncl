<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region bottom="11.67%" height="80.00%" id="region1" left="55.97%" right="3.04%" top="8.33%" width="40.98%" zIndex="2">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="des_video" region="region0">
			</descriptor>
			<descriptor id="des_fot" region="region1">
			</descriptor>
		</descriptorBase>
		<connectorBase id="connectorBase1">
			<causalConnector id="onKeyViewImage">
				<connectorParam name="keyCode">
				</connectorParam>
				<simpleCondition key="$keyCode" role="onSelection">
				</simpleCondition>
				<simpleAction role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="des_video" id="video2" src="D:/UCuenca/OP 5 - TV Digital/Talleres/Taller 6/video2.mp4">
		</media>
		<media descriptor="des_fot" id="foto" src="D:/UCuenca/OP 5 - TV Digital/Talleres/Taller 6/foto.jpg">
		</media>
		<port component="video2" id="p0">
		</port>
		<link id="link1" xconnector="onKeyViewImage">
			<bind component="video2" role="onSelection">
				<bindParam name="keyCode" value="RED">
				</bindParam>
			</bind>
			<bind component="foto" role="start">
			</bind>
		</link>
	</body>
</ncl>
