<ncl id="nclClicks" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="20.00%" id="rgWin" left="10.00%" top="40.00%" width="20.00%" zIndex="-1">
			</region>
			<region bottom="25.62%" height="50.00%" id="rgLua" left="39.70%" right="10.30%" top="24.38%" width="50.00%" zIndex="-1">
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor focusIndex="luaIdx" id="dsLua" region="rgLua">
			</descriptor>
			<descriptor id="dsWin" region="rgWin">
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
		<port component="lua" id="entryPoint">
		</port>
		<media id="programSettings" type="application/x-ginga-settings">
			<property name="service.currentKeyMaster" value="luaIdx">
			</property>
		</media>
		<media descriptor="dsLua" id="lua" src="monkey.lua">
			<area id="fim">
			</area>
		</media>
		<media descriptor="dsWin" id="win" src="win.jpg">
		</media>
		<link id="link1" xconnector="onBeginStart">
			<bind component="lua" interface="fim" role="onBegin">
			</bind>
			<bind component="win" role="start">
			</bind>
		</link>
	</body>
</ncl>
