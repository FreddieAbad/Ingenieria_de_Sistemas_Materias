<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
			<causalConnector id="keySelectionStopSetStart">
				<simpleCondition key="$key" role="onSelection">
				</simpleCondition>
				<compoundAction operator="seq">
					<simpleAction role="stop">
					</simpleAction>
					<simpleAction role="set" value="$var">
					</simpleAction>
					<simpleAction role="start">
					</simpleAction>
				</compoundAction>
				<connectorParam name="keyCode">
				</connectorParam>
				<connectorParam name="var">
				</connectorParam>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="imagen" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="100.00%" id="video" left="0.00%" top="0.00%" width="100.00%" zIndex="3">
				</region>
				<region height="13.96%" id="boton" left="88.99%" top="85.83%" width="10.89%" zIndex="1">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dV" region="video">
			</descriptor>
			<descriptor id="dI" region="imagen">
			</descriptor>
			<descriptor id="dB" region="boton">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media id="video1" src="Media/2.mp4">
		</media>
		<media id="imagen1" src="Media/p2 (1).png">
		</media>
		<media id="boton1" src="Media/p1 (2).png">
		</media>
		<port component="video1" id="p0">
		</port>
	</body>
</ncl>
