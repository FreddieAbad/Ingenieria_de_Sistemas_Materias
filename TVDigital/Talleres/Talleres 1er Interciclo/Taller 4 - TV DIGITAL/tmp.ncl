<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<causalConnector id="onBeginStartDelay">
				<simpleCondition role="onBegin">
				</simpleCondition>
				<simpleAction delay="3s" max="unbounded" role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="80.00%" id="region1" left="10.00%" top="10.00%" width="80.00%" zIndex="2">
					<region height="25.78%" id="region2" left="81.84%" top="71.88%" width="16.40%" zIndex="3">
					</region>
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor explicitDur="10s" id="d0" region="region1" transIn="trans">
			</descriptor>
			<descriptor explicitDur="10s" id="d1" region="region2" transIn="trans">
			</descriptor>
			<descriptor explicitDur="10s" id="d2" region="region0" transIn="trans">
			</descriptor>
		</descriptorBase>
		<transitionBase id="transitionBase1">
			<transition dur="4s" id="trans" type="fade">
			</transition>
		</transitionBase>
	</head>
	<body id="myBodyID">
		<port component="m0" id="p0">
		</port>
		<media descriptor="d0" id="m0" src="taller 4 conectores.mp4">
		</media>
		<media descriptor="d1" id="m1" src="taller 4 conectores.png">
			<property name="transparency" value="50%">
			</property>
		</media>
		<media descriptor="d2" id="m2" src="blue.jpg">
		</media>
		<port component="m2" id="p1">
		</port>
		<link id="l0" xconnector="onBeginStartDelay">
			<bind component="m0" role="onBegin">
			</bind>
			<bind component="m1" role="start">
			</bind>
		</link>
	</body>
</ncl>
