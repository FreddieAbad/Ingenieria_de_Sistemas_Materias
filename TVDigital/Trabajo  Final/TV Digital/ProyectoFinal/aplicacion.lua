hostIPServidor = '192.168.1.100'

local dx, dy = canvas:attrSize()

---------------------------------------------------------------------------------------------------
--  F U N C I O N E S   P A R A  C O M U N I C A C I O N   C O N   E L   S E R V I D O R         --  
---------------------------------------------------------------------------------------------------
function conectarServidor()
  event.post {
    class = 'tcp',
    type  = 'connect',
    host  = hostIPServidor,
    port  = '5000',
  }
end

function getRanking(connectionID, mensaje)
  event.post {
    class = 'tcp',
    type  = 'data',
    connection = connectionID,
    value = mensaje,
  }
end

function disconnect(connectionID) 
    event.post {
      class      = 'tcp',
      type       = 'disconnect',
      connection = connectionID,
    }
end

--datos

function writeResponse(event)
    if(event.error) then
      write(event.error)
    else
      mensaje = tostring(event.value)         
      
      code1 = buscarCadena(mensaje, 'multimedia1')      
      code2 = buscarCadena(mensaje, 'multimedia2')      
      code3 = buscarCadena(mensaje, 'multimedia3')      
      code4 = buscarCadena(mensaje, 'multimedia4')      
      
      write(code1..'-'..code2..'-'..code3..'-'..code4) 
      
      local m1 = canvas:new('media/fotos/'..code1..'.png')
      local m2 = canvas:new('media/fotos/p/'..code2..'.png')
      local m3 = canvas:new('media/fotos/p/'..code3..'.png')
      local m4 = canvas:new('media/fotos/p/'..code4..'.png')
      
      
      dibujarBoton(m1, '', 10, 2)
      
      dibujarBotonLateral(m2, dx/2,0)
      dibujarBotonLateral(m3, dx/2,270)
      dibujarBotonLateral(m4, dx/2,530)
      
      dibujarMenu()
      
    end    
end


function dibujarBoton(imagen, texto, posX, posY)
  canvas:compose(posX,posY+50,imagen)
  canvas:attrFont('Tiresias',20, 'bold')
  canvas:attrColor('white')
  canvas:drawText(dx/4, posY, texto)
  canvas:flush()
end
function dibujarBotonLateral(imagen, posX, posY)
  canvas:compose(posX+10,posY,imagen)
  canvas:flush()
end

function dibujarMenu()
	  canvas:attrColor('white')
    canvas:drawRect('fill',dx-250, 0, 250, dy)
    canvas:flush()
    
    dibujarOpcion("Inicio",dx-250,50)
    dibujarOpcion("Detalles",dx-250,210)
    dibujarOpcion("Filtros",dx-250,370)
    dibujarOpcion("Rating",dx-250,530)
        
end

function dibujarOpcion(texto, posX, posY)
    canvas:attrColor('blue')
    canvas:drawRect('fill',posX+50, posY, 150, 150)
    
    
    canvas:attrColor('white')
    canvas:attrFont('Tiresias',15, 'bold')
    canvas:drawText(posX + 90,posY+60, texto)
    
    canvas:flush()
    
end

function buscarCadena(cadena, buscar)
	x1, x2 = string.find(cadena,'<'..buscar..'>')
	x3, x4 = string.find(cadena,'</'..buscar..'>') 
	encontrado = string.sub(cadena, x2+1, x3-1)
	return encontrado
end

function write(text)
  canvas:attrColor('black')
  canvas:clear()
  -- Seteamos los atributos de la letra
  canvas:attrFont('Tiresias', 20, 'bold')
  canvas:attrColor('red')
  -- Dibujamos un texto en x=50, y=50
  canvas:drawText(10, 10, text)
  -- Actualizamos la pantalla
  canvas:flush()
end

function pruebaEscritura(text)
    canvas:attrColor('black')
    canvas:drawRect('fill',0, 0, dx/2, 50)    
    
    canvas:attrColor('white')
    canvas:attrFont('Tiresias',15, 'bold')
    canvas:drawText(10 ,10, text)
    
    canvas:flush()
end

local user = ''

function panelLogin(text)
    canvas:attrColor('black')
    canvas:drawRect('fill',0, 0, dx-250, dy)  
    
    canvas:attrColor('white')
    canvas:attrFont('Tiresias',15, 'bold')
    user = user..text
    canvas:drawText(10 ,50, user)
        
    canvas:flush()
end


---------------------------------------------------------------------------------------------------
--  F U N C I O N E S   P A R A  C O M U N I C A C I O N   C O N   E L   S E R V I D O R         --  
---------------------------------------------------------------------------------------------------

function handler (evt)
  
  if (evt.class == 'tcp' and evt.type == 'connect'  ) then
    getRanking(evt.connection, "1-Descocido\n")
   end

  if (evt.class == 'tcp' and evt.type == 'data') then
     writeResponse(evt)          
  end    
  
  if evt.key~=null then
    if evt.class == 'key' then
      if evt.type == 'press' then       
        pruebaEscritura('Control teclado: '..evt.key)   
        if evt.key == 'RED' then       
           panelLogin(evt.key)     
        end      
        if evt.key == 'BLUE' then       
            if (evt.class == 'tcp' and evt.type == 'connect'  ) then
              getRanking(evt.connection, "1-Descocido\n")
             end
          
            if (evt.class == 'tcp' and evt.type == 'data') then
               writeResponse(evt)          
            end  
        end   
      end 
    end 
  end 
  
end

---------------------------------------------------------------------------------------------------
--  F U N C I O N E S   P A R A  C O M U N I C A C I O N   C O N   E L   S E R V I D O R         --  
---------------------------------------------------------------------------------------------------
conectarServidor()
event.register(handler)

