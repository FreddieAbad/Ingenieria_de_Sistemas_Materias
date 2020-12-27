<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region bottom="11.67%" height="80.00%" id="region1" left="55.97%" right="3.04%" top="8.33%" width="40.98%" zIndex="2">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dv" region="region0">
			</descriptor>
			<descriptor id="di" region="region1">
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
		<media descriptor="dv" id="video" src="rec.mp4">
		</media>
		<media descriptor="di" id="img" src="img.jpg">
		</media>
		<port component="video" id="p0">
		</port>
		<link id="link1" xconnector="onKeyViewImage">
			<bind component="video" role="onSelection">
				<bindParam name="keyCode" value="BLUE">
				</bindParam>
			</bind>
			<bind component="img" role="start">
			</bind>
		</link>
	</body>
</ncl>
