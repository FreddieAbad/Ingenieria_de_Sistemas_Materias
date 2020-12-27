<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<causalConnector id="onKeySelectionStart">
				<simpleCondition key="RED" role="onSelection">
				</simpleCondition>
				<simpleAction max="1" qualifier="par" role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region bottom="51.46%" height="38.54%" id="region1" left="9.95%" right="51.87%" top="10.00%" width="38.17%" zIndex="2">
				</region>
				<region bottom="10.00%" height="37.50%" id="region2" left="9.25%" right="10.07%" top="52.50%" width="80.68%" zIndex="3">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="d1" region="region1">
			</descriptor>
			<descriptor id="d2" region="region2">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="d1" id="m0" src="2.mp4">
		</media>
		<port component="m0" id="p0">
		</port>
		<media descriptor="d2" id="m1" src="t5.png">
		</media>
		<link id="l0" xconnector="onKeySelectionStart">
			<bind component="m0" role="onSelection">
			</bind>
			<bind component="m1" role="start">
			</bind>
		</link>
	</body>
</ncl>
