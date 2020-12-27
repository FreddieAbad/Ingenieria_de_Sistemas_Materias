<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conn" documentURI="defaultConnBase.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="region0" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="80.00%" id="region1" left="9.95%" top="10.00%" width="50.82%" zIndex="2">
				</region>
				<region height="46.46%" id="region2" left="66.98%" top="21.88%" width="23.65%" zIndex="3">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="d0" region="region1">
			</descriptor>
			<descriptor id="d1" region="region1">
			</descriptor>
			<descriptor id="d2" region="region2">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="d0" id="m0" src="1.mp4">
		</media>
		<media descriptor="d2" id="m1" src="t5.png">
		</media>
		<media descriptor="d1" id="m2" src="2.mp4">
		</media>
		<port component="m0" id="p0">
		</port>
		<link id="l0" xconnector="conn#onBeginStart">
			<bind component="m0" role="onBegin">
			</bind>
			<bind component="m1" role="start">
			</bind>
		</link>
		<link id="l1" xconnector="conn#onEndStart">
			<bind component="m0" role="onEnd">
			</bind>
			<bind component="m2" role="start">
			</bind>
		</link>
		<link id="l2" xconnector="conn#onEndStop">
			<bind component="m2" role="onEnd">
			</bind>
			<bind component="m1" role="stop">
			</bind>
		</link>
	</body>
</ncl>
