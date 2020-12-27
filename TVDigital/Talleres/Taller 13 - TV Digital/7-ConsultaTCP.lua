-- EJEMPLO TCP

-- Utiliza las funciones de tcp.lua que implementa el modulo tcp propio de lua
require 'tcp'

local HOST = 'www2.elo.utfsm.cl' --Host a conectarse
local url = '/~elo323/survey/get_question.php' --Pagina solicitada(Pag ejemplo tarea 2013)
local result = ''  --Resultado html de la busqueda
local question = ''

--background
canvas:attrColor('navy')
canvas:clear()

canvas:attrFont("Tiresias", 20, "normal") -- Se asignan sitintos tipos de letras con disitntos tamaños
canvas:attrColor('blue') -- Se define el color de todo lo que se dibuje/escriba

-- Implementa dentro de las funciones que tiene tcp.lua
 tcp.execute(
        function () 
			tcp.connect(HOST, 80)
			tcp.send('GET '..url..' HTTP/1.1\r\n')
			tcp.send('Host: '..HOST..'\r\n')
			tcp.send('\r\n')
			
			result = tcp.receive()
			canvas:drawText(30,200,'resultado: '..result)

			-- En caso de existir resultado
			if result then
				_,_,question = string.find(result, "<question>(.*)</question>") -- Busca resultado entre backets
	        else
		        result = 'error: '
	        end
			-- La asignalcion de estos parametros solo tiene valor dentro de la funcion
			canvas:drawText(30,200,'resultado: '..result)
			canvas:drawText(30,380,'Pregunta: '..question)
			canvas:flush() 
			tcp.disconnect()
		end
)

-- Escritura adicional
canvas:drawText(30,80,'HOST: '..HOST)
canvas:drawText(30,120,'url: '..url)

-- flush
canvas:flush()