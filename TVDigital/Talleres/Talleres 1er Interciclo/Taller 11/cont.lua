local contador=0

function conteoN()
	contador=contador+1
	canvas:attrColor('blue')
	canvas:clear(290,230,150,100)
	canvas:attrColor('white')
	canvas:attrFont('Arial',24)
	canvas:drawText(320,250,contador)
	
	canvas:flush()
	event.timer(1000,conteoN)
end
canvas:attrColor('blue')
canvas:clear()
conteoN()