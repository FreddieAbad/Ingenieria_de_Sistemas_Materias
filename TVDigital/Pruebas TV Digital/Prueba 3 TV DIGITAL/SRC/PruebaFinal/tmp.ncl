<ncl id="nclClicks">
	<head>
		<regionBase id="regionBase0">
			<region height="50.00%" id="region1" left="7.14%" top="10.00%" width="82.44%" zIndex="1">
			</region>
			<region height="20.00%" id="region2" left="6.56%" top="68.33%" width="70.14%" zIndex="2">
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor focusIndex="luaIdx" id="dLua" region="region1">
			</descriptor>
			<descriptor id="dGanar" region="region2">
			</descriptor>
			<descriptor id="dGanar2" region="region2">
			</descriptor>
			<descriptor id="dGanar3" region="region2">
			</descriptor>
		</descriptorBase>
		<connectorBase id="connectorBase1">
			<causalConnector id="onBeginStart">
				<simpleCondition role="onBegin">
				</simpleCondition>
				<simpleAction role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dLua" id="mainLua" src="mainLua.lua">
			<area id="fim">
			</area>
			<area id="fim2">
			</area>
			<area id="fim3">
			</area>
		</media>
		<media id="programSettings" type="application/x-ginga-settings">
			<property name="service.currentKeyMaster" value="luaIdx">
			</property>
		</media>
		<media descriptor="dGanar" id="win" src="jugador1.lua">
		</media>
		<port component="mainLua" id="p0">
		</port>
		<link id="link1" xconnector="onBeginStart">
			<bind component="mainLua" interface="fim" role="onBegin">
			</bind>
			<bind component="win" role="start">
			</bind>
		</link>
		<media descriptor="dGanar" id="win2" src="jugador2.lua">
		</media>
		<media descriptor="dGanar" id="win3" src="jugador3.lua">
		</media>
		<link id="l0" xconnector="onBeginStart">
			<bind component="mainLua" interface="fim2" role="onBegin">
			</bind>
			<bind component="win2" role="start">
			</bind>
		</link>
		<link id="l1" xconnector="onBeginStart">
			<bind component="mainLua" interface="fim3" role="onBegin">
			</bind>
			<bind component="win3" role="start">
			</bind>
		</link>
	</body>
</ncl>
