<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="conIDBase">
			<causalConnector id="onKeySelectionStart">
				<connectorParam name="keyCode">
				</connectorParam>
				<simpleCondition key="$keyCode" role="onSelection">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="seq" role="start">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onEndStopN">
				<simpleCondition max="unbounded" qualifier="and" role="onEnd">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="par" role="stop">
				</simpleAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="0">
				<region height="35.21%" id="region1" left="9.95%" top="10.00%" width="32.55%" zIndex="1">
				</region>
				<region height="35.83%" id="region2" left="9.72%" top="54.58%" width="33.49%" zIndex="1">
				</region>
				<region height="37.50%" id="region3" left="61.59%" top="8.54%" width="28.34%" zIndex="1">
				</region>
				<region height="37.08%" id="region4" left="61.83%" top="52.29%" width="28.34%" zIndex="1">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dv1" region="region1">
			</descriptor>
			<descriptor id="dv2" region="region2">
			</descriptor>
			<descriptor id="di1" region="region3">
			</descriptor>
			<descriptor id="di2" region="region4">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="di1" id="img1" src="i2.jpg">
		</media>
		<media descriptor="di2" id="img2" src="i1.png">
		</media>
		<media descriptor="dv2" id="video2" src="2.mp4">
		</media>
		<media descriptor="dv1" id="video1" src="1.mp4">
		</media>
		<port component="video1" id="p0">
		</port>
		<link id="l1" xconnector="onKeySelectionStart">
			<bind component="video1" role="onSelection">
				<bindParam name="keyCode" value="BLUE">
				</bindParam>
			</bind>
			<bind component="img1" role="start">
			</bind>
			<bind component="img2" role="start">
			</bind>
			<bind component="video2" role="start">
			</bind>
		</link>
		<link id="l2" xconnector="onEndStopN">
			<bind component="video1" role="onEnd">
			</bind>
			<bind component="video2" role="onEnd">
			</bind>
			<bind component="img1" role="stop">
			</bind>
			<bind component="img2" role="stop">
			</bind>
		</link>
	</body>
</ncl>
