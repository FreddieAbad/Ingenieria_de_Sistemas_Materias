function handler(evt)
	canvas:attrColor('white')
	if evt.class=='key' and evt.type=='press' then
		canvas:clear()
		canvas:attrColor('black')
		canvas:attrFont('Arial',24)
		canvas:drawText(50,50,' '..evt.key)
		canvas:flush()
	end
end

event.register(handler)
