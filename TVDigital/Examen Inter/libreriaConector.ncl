<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="connectorBase1">
			<causalConnector id="onEndStart">
				<simpleCondition role="onEnd">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="seq" role="start">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onBeginStart">
				<simpleCondition role="onBegin">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="seq" role="start">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onEndStop">
				<simpleCondition max="unbounded" qualifier="and" role="onEnd">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="seq" role="stop">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onSelectionKey">
				<simpleCondition key="$keyCode" role="onSelection">
				</simpleCondition>
				<simpleAction max="unbounded" qualifier="par" role="start">
				</simpleAction>
			</causalConnector>
			<causalConnector id="onKeySelectionStop">
				<connectorParam name="keyCode1">
				</connectorParam>
				<simpleCondition key="$keyCode1" max="unbounded" qualifier="or" role="onSelection">
				</simpleCondition>
				<compoundAction operator="par">
					<simpleAction max="unbounded" qualifier="par" role="stop">
					</simpleAction>
					<simpleAction max="unbounded" qualifier="par" role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
			<causalConnector id="onKeySelectionBlue">
				<simpleCondition key="BLUE" role="onSelection">
				</simpleCondition>
				<compoundAction operator="par">
					<simpleAction max="unbounded" qualifier="par" role="stop">
					</simpleAction>
					<simpleAction max="unbounded" qualifier="par" role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
			<causalConnector id="onKeySelectionEnter">
				<simpleCondition key="ENTER" role="onSelection">
				</simpleCondition>
				<compoundAction operator="par">
					<simpleAction max="unbounded" qualifier="par" role="stop">
					</simpleAction>
					<simpleAction max="unbounded" qualifier="par" role="start">
					</simpleAction>
				</compoundAction>
			</causalConnector>
		</connectorBase>
	</head>
	<body id="myBodyID">
	</body>
</ncl>
