<ncl id="myNCLDocID">
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
		
	</head>
	<body id="myBodyID">
	</body>
</ncl>
