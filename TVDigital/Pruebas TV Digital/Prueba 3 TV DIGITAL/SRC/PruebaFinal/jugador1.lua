function writeTitle(text)
	canvas:attrColor('white')
	canvas:attrFont('Arial',24)
	canvas:drawText(50,50,text)
	canvas:flush()
end


canvas:attrColor('white')
writeTitle('Jugador Ganador 1 ')