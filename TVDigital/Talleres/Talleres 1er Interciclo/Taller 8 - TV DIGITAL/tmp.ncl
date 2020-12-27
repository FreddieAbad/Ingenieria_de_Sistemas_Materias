<ncl id="myNCLDocID">
	<head>
		<connectorBase id="connBaseId">
			<importBase alias="conecciones" documentURI="libreriaConector.ncl">
			</importBase>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="83.12%" id="region0" left="5.97%" top="6.04%" width="87.00%" zIndex="0">
				<region height="47.87%" id="region1" left="32.97%" top="22.81%" width="37.69%" zIndex="2">
					<region height="98.95%" id="region2" left="0.00%" top="0.52%" width="100.00%" zIndex="2">
					</region>
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dV1" region="region1">
			</descriptor>
			<descriptor id="dV2" region="region2">
			</descriptor>
			<descriptor id="dF" region="region0">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dV1" id="video1" src="../Taller 5 - TV DIGITAL/1.mp4">
			<property name="explicitDur" value="10s">
			</property>
			<property name="transparency" value="5%">
			</property>
		</media>
		<media descriptor="dV2" id="video2" src="../Taller 5 - TV DIGITAL/2.mp4">
			<property name="explicitDur" value="10s">
			</property>
			<property name="transparency" value="5%">
			</property>
		</media>
		<port component="video1" id="p0">
		</port>
		<media descriptor="dF" id="fondo" src="../Taller 7 - TV DIGITAL/i1.png">
		</media>
		<link id="l0" xconnector="conecciones#onEndStart">
			<bind component="video1" role="onEnd">
			</bind>
			<bind component="video2" role="start">
			</bind>
		</link>
		<link id="l1" xconnector="conecciones#onBeginStart">
			<bind component="video1" role="onBegin">
			</bind>
			<bind component="fondo" role="start">
			</bind>
		</link>
		<link id="l2" xconnector="conecciones#onEndStop">
			<bind component="video2" role="onEnd">
			</bind>
			<bind component="fondo" role="stop">
			</bind>
		</link>
	</body>
</ncl>
