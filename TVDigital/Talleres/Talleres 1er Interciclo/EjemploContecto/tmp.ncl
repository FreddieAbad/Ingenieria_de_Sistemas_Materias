<ncl id="botoones" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<ruleBase id="ruleBase1">
			<rule comparator="eq" id="rule1" value="1" var="page">
			</rule>
			<rule comparator="eq" id="rule2" value="2" var="page">
			</rule>
			<rule comparator="eq" id="rule3" value="3" var="page">
			</rule>
		</ruleBase>
		<regionBase id="regionBase1">
			<region height="100.00%" id="all" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="70.00%" id="top" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				</region>
				<region height="20.00%" id="middle" left="0.00%" top="70.00%" width="100.00%" zIndex="1">
				</region>
				<region height="10.00%" id="bottonLeft" left="0.00%" top="90.00%" width="50.00%" zIndex="1">
				</region>
				<region height="10.00%" id="bottonRight" left="50.00%" top="90.00%" width="50.00%" zIndex="1">
				</region>
				<region height="5.00%" id="overRegion" left="80.00%" top="93.00%" width="5.00%" zIndex="1">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="bigImageDesc" region="all">
			</descriptor>
			<descriptor id="smallImageDesc" region="top">
			</descriptor>
			<descriptor id="textDesc" region="middle">
			</descriptor>
			<descriptor id="blueDesc" region="bottonLeft">
			</descriptor>
			<descriptor id="redDesc" region="bottonRight">
			</descriptor>
			<descriptor id="backDesc" region="overRegion">
			</descriptor>
		</descriptorBase>
		<connectorBase id="connectorBase1">
			<causalConnector id="changePage">
				<connectorParam name="key">
				</connectorParam>
				<connectorParam name="pagina">
				</connectorParam>
				<simpleCondition key="$key" role="onSelection">
				</simpleCondition>
				<compoundAction operator="seq">
					<simpleAction role="stop">
					</simpleAction>
					<simpleAction role="set" value="$pagina">
					</simpleAction>
					<simpleAction role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
		</connectorBase>
	</head>
	<body id="body1">
		<port component="selector" id="pp">
		</port>
		<port component="blueButton" id="p2">
		</port>
		<port component="redButton" id="p3">
		</port>
		<port component="backButton" id="pb">
		</port>
		<switch id="selector">
			<context id="pantallaInicial">
				<port component="pastillas" id="p0">
				</port>
				<port component="texto" id="p1">
				</port>
				<media descriptor="smallImageDesc" id="pastillas" src="lifia.jpg">
				</media>
				<media descriptor="textDesc" id="texto" src="texto.txt">
					<property name="fontFamily" value="Verdana">
					</property>
					<property name="fontSize" value="20">
					</property>
					<property name="fontColor" value="red">
					</property>
				</media>
			</context>
			<context id="pantallaMatrix">
				<port component="matrix" id="pm">
				</port>
				<media descriptor="bigImageDesc" id="matrix" src="yellow.jpg">
				</media>
			</context>
			<context id="pantallaMundoFeliz">
				<port component="mundoFeliz" id="pmf">
				</port>
				<media descriptor="bigImageDesc" id="mundoFeliz" src="taller1.jpg">
				</media>
			</context>
			<bindRule constituent="pantallaInicial" rule="rule1">
			</bindRule>
			<bindRule constituent="pantallaMatrix" rule="rule2">
			</bindRule>
			<bindRule constituent="pantallaMundoFeliz" rule="rule3">
			</bindRule>
		</switch>
		<media descriptor="blueDesc" id="blueButton" src="blue.jpg">
		</media>
		<media descriptor="redDesc" id="redButton" src="red.jpg">
		</media>
		<media descriptor="backDesc" id="backButton" src="background.jpg">
		</media>
		<media id="variables" type="application/x-ncl-settings">
			<property name="page" value="1">
			</property>
		</media>
		<link id="link1" xconnector="changePage">
			<bind component="backButton" role="onSelection">
				<bindParam name="key" value="CURSOR_LEFT">
				</bindParam>
			</bind>
			<bind component="selector" role="stop">
			</bind>
			<bind component="variables" interface="page" role="set">
				<bindParam name="pagina" value="1">
				</bindParam>
			</bind>
			<bind component="selector" role="start">
			</bind>
		</link>
		<link id="link2" xconnector="changePage">
			<bind component="redButton" role="onSelection">
				<bindParam name="key" value="RED">
				</bindParam>
			</bind>
			<bind component="selector" role="stop">
			</bind>
			<bind component="variables" interface="page" role="set">
				<bindParam name="pagina" value="2">
				</bindParam>
			</bind>
			<bind component="selector" role="start">
			</bind>
		</link>
		<link id="link3" xconnector="changePage">
			<bind component="blueButton" role="onSelection">
				<bindParam name="key" value="BLUE">
				</bindParam>
			</bind>
			<bind component="selector" role="stop">
			</bind>
			<bind component="variables" interface="page" role="set">
				<bindParam name="pagina" value="3">
				</bindParam>
			</bind>
			<bind component="selector" role="start">
			</bind>
		</link>
	</body>
</ncl>
