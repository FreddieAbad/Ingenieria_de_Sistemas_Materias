
-- img1: guarda a imagem, posicao inicial e dimensoes
local img = canvas:new('d.mp4')
local dx, dy = img:attrSize()
local img1 = { img=img, x=10, y=10, dx=dx, dy=dy }

local img = canvas:new('img2.png')
local dx, dy = img:attrSize()
local img2 = { img=img, x=10, y=70, dx=dx, dy=dy }

local img = canvas:new('img3.png')
local dx, dy = img:attrSize()
local img3 = { img=img, x=10, y=130, dx=dx, dy=dy }

-- meta: guarda a imagem, posicao inicial e dimensoes
local img = canvas:new('ind.jpg')
local dx, dy = img:attrSize()
local meta = { img=img, x=999, y=10, dx=dx, dy=dy }


function writeTitle(text)
	canvas:attrColor('black')
	canvas:attrFont('Arial',24)
	canvas:drawText(50,50,text)
	canvas:flush()
end



-- Funcao de redesenho:
-- chamada a cada tecla pressionada
-- primeiro o fundo, depois a meta e por fim o macaco
function redraw ()
	canvas:attrColor('white')
	canvas:drawRect('fill', 0,0, canvas:attrSize())
	canvas:compose(meta.x, meta.y, meta.img)
	canvas:compose(img1.x, img1.y, img1.img)
	canvas:compose(img2.x, img2.y, img2.img)
	canvas:compose(img3.x, img3.y, img3.img)
	canvas:flush()
end

-- Funcao de colisao:
-- chamada a cada tecla pressionada
-- checa se o macaco esta em cima da meta
function collide (A, B)
	local ax1, ay1 = A.x, A.y
	local ax2, ay2 = ax1+A.dx, ay1+A.dy
	local bx1, by1 = B.x, B.y
	local bx2, by2 = bx1+B.dx, by1+B.dy

	if ax1 > bx2 then
		return false
	elseif bx1 > ax2 then
		return false
	elseif ay1 > by2 then
		return false
	elseif by1 > ay2 then
		return false
	end

	return true
end

local IGNORE = false

-- Funcao de tratamento de eventos:
function handler (evt)
	if IGNORE then
		return
	end

	-- apenas eventos de tecla me interessam
	if evt.class == 'key' and evt.type == 'press'
	then
		-- apenas as setas movem o macaco
		if evt.key == 'CURSOR_RIGHT' then
			img1.x = img1.x + 10
			img2.x = img2.x + 10
			img3.x = img3.x + 10
		end

        -- Colisiones
		if collide(img1, meta) then
			canvas:flush()
			event.post {
                class  = 'ncl',
                type   = 'presentation',
                label  = 'fim',
                action = 'start',
            }
			-- Ignorar Eventos Posteriores
			IGNORE = true
		end
		if collide(img2, meta) then		
			canvas:flush()
			canvas:attrColor('black')
			canvas:attrFont('Arial',24)
			canvas:drawText(20,300,'Jugador Ganador : Jugador 2')
			
			-- Colisiones
			event.post {
                class  = 'ncl',
                type   = 'presentation',
                label  = 'fim2',
                action = 'start',
            }
			-- Ignorar Eventos Posteriores
			IGNORE = true
		end
		if collide(img3, meta) then
			canvas:flush()
			-- Colisiones
			event.post {
                class  = 'ncl',
                type   = 'presentation',
                label  = 'fim3',
                action = 'start',
            }
			-- Ignorar Eventos Posteriores
			IGNORE = true
		end
	end

    -- redesenha a tela toda
    redraw()
end
canvas:flush()
event.register(handler)
