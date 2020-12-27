
require 'tcp'

local HOST = 'localhost' --Host a conectarse
local url = 'http://'..HOST..'/Desktop/index.php' 
local result = ''  --Resultado html de la busqueda
local question = ''

function subir(val)
	tcp.execute(
		function () 
			tcp.connect(HOST, 80)
			local url1='Get http://'..HOST..'/Desktop/index.php?action=registrar&id='..val..'\n'
			tcp.send(url1)
			tcp.disconnect()
		end
	)
end

function resultados()
	tcp.execute(
        function () 
			tcp.connect(HOST, 80)
			tcp.send('GET '..url..' \r\n')
			tcp.send('Host: '..HOST..'\r\n')
			result = tcp.receive()

			-- En caso de existir resultado

			canvas:attrColor('white')
			canvas:drawRect('fill', 0, 0, 400, 300)
			canvas:clear()

			canvas:attrFont("Verdana", 25, "bold") -- Se asignan sitintos tipos de letras con disitntos tamaños
			canvas:attrColor('black') -- Se define el color de todo lo que se dibuje/escriba
			canvas:flush()

			canvas:drawText(10,90,'Jugador: 1')
			_,_,question = string.find(result, "<td id='op1'>(.*)</td id='op1'>")
			canvas:drawText(10,110,'Resultado: '..question)
			canvas:drawText(10,130,'Jugador: 2')
			_,_,question = string.find(result, "<td id='op2'>(.*)</td id='op2'>")
			canvas:drawText(10,150,'Resultado: '..question)
			canvas:drawText(10,170,'Jugador: 3')

			_,_,question = string.find(result, "<td id='op3'>(.*)</td id='op3'>")
			canvas:drawText(10,190,'Resultado: '..question)
			canvas:drawText(10,210,'Jugador: 4')

			_,_,question = string.find(result, "<td id='op4'>(.*)</td id='op4'>")
			canvas:drawText(10,230,'Resultado: '..question)
			canvas:flush()
		end
	)
end
local cont=0
function handler(evt)
	if evt.key~=null then
		if evt.key=='RED' and cont==0 then
			subir(1)
			cont=cont+1
		end
		if evt.key=='GREEN' and cont==0 then
			subir(2)
			cont=cont+1
		end
		if evt.key=='YELLOW' and cont==0 then
			subir(3)
			cont=cont+1
		end
		if evt.key=='BLUE' and cont==0 then
			subir(4)
			cont=cont+1
		end
		if evt.key=='RED' or evt.key=='GREEN' or evt.key=='YELLOW' or evt.key=='BLUE' then
			event.timer(500,resultados)
		end
	end
end

event.register(handler)