<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region bottom="11.46%" height="80.00%" id="region1" left="52.34%" right="4.10%" top="8.54%" width="43.56%" zIndex="2">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="des_video" region="region0">
			</descriptor>
			<descriptor id="des_foto" region="region1">
			</descriptor>
		</descriptorBase>
		<connectorBase id="connectorBase1">
			<causalConnector id="onKeyViewImage">
				<simpleCondition key="RED" role="onSelection">
				</simpleCondition>
				<simpleAction role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="des_foto" id="foto" src="foto.jpg">
		</media>
		<media descriptor="des_video" id="video2" src="video2.mp4">
		</media>
		<port component="video2" id="p0">
		</port>
		<link id="link1" xconnector="onKeyViewImage">
			<bind component="video2" role="onSelection">
			</bind>
			<bind component="foto" role="start">
			</bind>
		</link>
	</body>
</ncl>
