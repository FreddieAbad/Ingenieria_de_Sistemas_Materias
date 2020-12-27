<ncl id="myNCLDocID">
	<head>
		<regionBase id="regionBase0">
			<region bottom="8.75%" height="57.71%" id="region0" left="20.61%" right="3.40%" top="33.54%" width="76.00%" zIndex="4">
			</region>
			<region bottom="20.62%" height="68.96%" id="region1" left="9.13%" right="7.03%" top="10.42%" width="83.84%" zIndex="2">
			</region>
			<region bottom="14.58%" height="61.04%" id="region2" left="14.75%" right="5.27%" top="24.38%" width="79.98%" zIndex="3">
			</region>
			<region bottom="0.00%" height="58.96%" id="region3" left="25.76%" right="0.00%" top="41.04%" width="74.24%" zIndex="5">
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="d0" region="region0">
			</descriptor>
			<descriptor id="d1" region="region1">
			</descriptor>
			<descriptor id="d2" region="region2">
			</descriptor>
			<descriptor id="d3" region="region3">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="d0" id="m0" src="blue.jpg">
		</media>
		<media descriptor="d1" id="m1" src="green.jpg">
		</media>
		<media descriptor="d2" id="m2" src="red.jpg">
		</media>
		<port component="m2" id="p0">
		</port>
		<port component="m0" id="p1">
		</port>
		<port component="m1" id="p2">
		</port>
		<media descriptor="d3" id="m3" src="yellow.jpg">
		</media>
		<port component="m3" id="p3">
		</port>
	</body>
</ncl>
