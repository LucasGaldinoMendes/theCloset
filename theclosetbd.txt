create database thecloset
go

use thecloset
go

create table pessoas
(
	id 		int	 	not null primary key identity,
	nome 		varchar(50)	not null,
	documento 	varchar(16) 	not null unique,
	telefone 	varchar(11)	not null,
	status 		int, 
	check (status in (0,1,2,3,4))
	
)

go

create table vendedores
(
	pessoa_id 	int	not null 	primary key references pessoas,
	salario 	money 	not null,
	check (salario > 0 )

) 

go 

create table fornecedores 
(
	pessoa_id 	int 	not null 	primary key references pessoas,
	descricao varchar(50)	not null
	
)

go

create table vendas
(
	id 		int 		not null 	primary key identity,
	cpf 		varchar(12),
	data 		datetime 	not null,
	valor 		money		not null,
	status 		int,
	vendedor_id 	int 		not null 	references vendedores,
	check (status in (0,1,2,3,4))
)

go

create table produtos
(
	codigo 		int 		not null 	primary key identity,
	descricao 	varchar(50),
	estoque 	int 		not null,
	tamanho 	varchar(6) 	not null,
	valorCompra	money 		not null,
	valorVenda	money 		not null,
	status		int,
	check (status >=0 and status <= 4)

) 
go

create table produtos_vendas
(

	
	qtd		int		not null,
	valor 		money,
	produto_id	int		not null	references produtos,
	venda_id	int		not null	references vendas,
	primary key (produto_id, venda_id)
)
go

create table compras
(
	id 		int		not null	primary key identity,
	data 		datetime 	not null,
	valor 		money,
	status 		int,
	fornecedor_id 	int 		not null 	references fornecedores,
	check (status in (0,1,2,3,4))
)

go

create table produtos_compras
(

	
	qtd		int		not null,
	valor 		money,
	produto_id	int		not null	references produtos,
	compra_id	int		not null	references compras,
	primary key (produto_id, compra_id)
)
go

create procedure addVendedor
(
	@nome varchar(50), @documento varchar(16), @telefone varchar(12), @salario money
)
as
begin
	begin tran
	begin try	
		insert into pessoas values (@nome, @documento, @telefone, 1)
		insert into vendedores values (@@identity, @salario) 
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure addFornecedor
(
	@nome varchar(50), @documento varchar(16), @telefone varchar(12), @descricao varchar(50)
)
as
begin
	begin tran
	begin try	
		insert into pessoas values (@nome, @documento, @telefone, 1)
		insert into fornecedores values (@@identity, @descricao) 
			
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go



create procedure addProduto
(
	@descricao varchar(50), @estoque int, @tamanho varchar(6), @valorCompra money, @valorVenda money
)
as
begin
	begin tran
	begin try	
		insert into produtos values (@descricao, @estoque, @tamanho, @valorCompra, @valorVenda, 1)
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure addVenda
(
	@cpf varchar(12), @valor money, @vendedor_id int, @venda_id int output
)
as
begin
	begin tran
	begin try	
		insert into vendas values (@cpf, getdate(), @valor, 1, @vendedor_id)
		commit
		set @venda_id = @@identity; 
	end try
	begin catch
		rollback	
		set @venda_id = 0;
	end catch
end
go





create procedure addCompra
(
	@valor money, @fornecedor_id int, @compra_id int output
)
as
begin
	begin tran
	begin try	
		insert into compras values (getdate(), @valor, 1, @fornecedor_id)
		commit
		set @compra_id = @@identity; 
	end try
	begin catch
		rollback	
		set @compra_id = 0;
	end catch
end
go

create procedure addProdutoVenda
(
	@qtd int, @valor money, @produto_id int, @venda_id int
)
as
begin
	begin tran
	begin try	
		insert into produtos_vendas values (@qtd, @valor, @produto_id, @venda_id)
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure addProdutoCompra
(
	@qtd int, @valor money, @produto_id int, @compra_id int
)
as
begin
	begin tran
	begin try	
		insert into produtos_compras values (@qtd, @valor, @produto_id, @compra_id)
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure altVendedor
(
	@id int, @nome varchar(50), @documento varchar(16), @telefone varchar(12),@status int, @salario money
)
as
begin
	begin tran
	begin try	
		update pessoas set nome = @nome, documento = @documento, telefone = @telefone, status = @status
		where id = @id
		update vendedores set salario = @salario
		where pessoa_id = @id
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure altFornecedor
(
	@id int, @nome varchar(50), @documento varchar(16), @telefone varchar(12),@status int, @descricao varchar(50)
)
as
begin
	begin tran
	begin try	
		update pessoas set nome = @nome, documento = @documento, telefone = @telefone, status = @status
		where id = @id
		update fornecedores set descricao = @descricao
		where pessoa_id = @id
		
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go


create procedure altProduto
(
	@id int, @descricao varchar(50), @estoque int, @tamanho varchar(6), @valorCompra money, @valorVenda money, @status int
)
as
begin
	begin tran
	begin try	
		update produtos set descricao = @descricao, estoque = @estoque, tamanho = @tamanho, valorCompra = @valorCompra, valorVenda = @valorVenda,  status = @status
		where codigo = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure altCompra
(
	@id int, @valor money, @status int, @fornecedor_id int
)
as
begin
	begin tran
	begin try	
		update compras set valor=@valor, status = @status, fornecedor_id = @fornecedor_id
		where id = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go


create procedure altVenda
(
	@id int, @cpf varchar(12), @valor money, @status int, @vendedor_id int
)
as
begin
	begin tran
	begin try	
		update vendas set cpf= @cpf, valor=@valor, status = @status, vendedor_id = @vendedor_id
		where id = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go


create procedure altProdutoVenda
(
	@produto_id int, @venda_id int, @qtd int, @valor money

)
as
begin
	begin tran
	begin try	
		update produtos_vendas set qtd= @qtd, valor= @valor
		where produto_id = @produto_id and venda_id = @venda_id
		
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure altProdutoCompra
(
	@produto_id int, @compra_id int, @qtd int, @valor money

)
as
begin
	begin tran
	begin try	
		update produtos_compras set qtd= @qtd, valor= @valor 
		where produto_id = @produto_id and compra_id = @compra_id
		
		
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure baixarEstoque (@codigo int, @qtd_vendida int)
as
begin
	begin tran
	begin try
		update produtos set estoque = estoque - @qtd_vendida
		where codigo = @codigo and estoque >= @qtd_vendida 
		commit 
	end try
	begin catch
		rollback				
	end catch	
end
go

create procedure aumentarEstoque (@codigo int, @qtd_comprada int)
as
begin
	begin tran
	begin try
		update produtos set estoque = estoque + @qtd_comprada
		where codigo = @codigo and estoque >= @qtd_comprada 
		commit 
	end try
	begin catch
		rollback				
	end catch	
end
go

create procedure excluirPessoa
(
	@id int
)
as
begin
	begin tran
	begin try
		update pessoas set status = 0
		where id = @id
		commit
	end try
	begin catch
		rollback
	end catch
end
go


create procedure excluirProduto
(
	@id int
)
as
begin
	begin tran
	begin try	
		update produtos set status = 0
		where codigo = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go

create procedure excluirVenda
(
	@id int
)
as
begin
	begin tran
	begin try	
		update vendas set status = 0
		where id = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go


create procedure excluirCompra
(
	@id int
)
as
begin
	begin tran
	begin try	
		update compras set status = 0
		where id = @id
		commit 
	end try
	begin catch
		rollback				
	end catch
end
go