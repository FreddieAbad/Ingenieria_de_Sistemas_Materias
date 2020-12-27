<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
			<causalConnector id="cambioPagina">
				<connectorParam name="key">
				</connectorParam>
				<connectorParam name="$page">
				</connectorParam>
				<simpleCondition key="$key" role="onSelection">
				</simpleCondition>
				<compoundAction operator="seq">
					<simpleAction role="stop">
					</simpleAction>
					<simpleAction role="set" value="$page">
					</simpleAction>
					<simpleAction role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="76.67%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
			</region>
		</regionBase>
		<ruleBase id="ruleBase1">
			<rule comparator="eq" id="rule1" value="1" var="page">
			</rule>
			<rule comparator="eq" id="rule2" value="2" var="page">
			</rule>
			<rule comparator="eq" id="rule3" value="3" var="page">
			</rule>
		</ruleBase>
	</head>
	<body id="myBodyID">
		<switch id="cambiaPagina">
			<switchPort id="switchPort1">
				<mapping component="Pagina1" interface="port1">
				</mapping>
				<mapping component="Pagina2" interface="port2">
				</mapping>
				<mapping component="Pagina3" interface="port3">
				</mapping>
			</switchPort>
			<context id="Pagina1">
				<port component="media1" id="port1">
				</port>
				<media id="media1" src="Media/fondoMenu.png">
				</media>
				<media id="media2" src="Media/p1 (2).png">
				</media>
				<media id="media3" src="Media/p1 (3).png">
				</media>
			</context>
			<context id="Pagina2">
				<port component="media4" id="port2">
				</port>
				<media id="media4" src="Media/p2 (1).png">
				</media>
				<media id="media5" src="Media/p2 (2).png">
				</media>
				<media id="media6" src="Media/p2 (3).png">
				</media>
			</context>
			<context id="Pagina3">
				<port component="media7" id="port3">
				</port>
				<media id="media7" src="Media/p3 (1).png">
				</media>
				<media id="media8" src="Media/p3 (2).png">
				</media>
				<media id="media9" src="Media/p3 (3).png">
				</media>
			</context>
			<bindRule constituent="Pagina1" rule="rule1">
			</bindRule>
			<bindRule constituent="Pagina2" rule="rule2">
			</bindRule>
			<bindRule constituent="Pagina3" rule="rule3">
			</bindRule>
		</switch>
		<port id="port4">
		</port>
		<media id="variable" type="application/x-ginga-settings">
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
			<bind component="variable" interface="page" role="set">
				<bindParam name="page" value="1">
				</bindParam>
			</bind>
			<bind component="selector" role="start">
			</bind>
		</link>
	</body>
</ncl>
