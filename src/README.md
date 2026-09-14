# Catálogo de Produtos

Este projeto é um requisito para completar a primeira parte do meu
treinamento como Engenheiro de Software  e tem por objetivo implementar 
um catálogo de produtos que poderá armazenar produtos eletrônicos e alimentícios.

O catálogo terá as seguintes funcionalidades:
- Adicionar um produto.
- Remover um produto pelo id.
- Verificar se um produto está cadastrado pelo id.
- Buscar um produto pelo id.
- Obter todos os produtos cadastrados.
- Obter somente os produtos eletrônicos.
- Associar uma categoria textual a um produto, por exemplo:
- "notebook" → produtos eletrônicos
- "food"     → produtos alimentícios
- Impedir que o mesmo produto seja cadastrado duas vezes.

Restrições:
- Você deve utilizar pelo menos uma Set.
- Deve utilizar pelo menos uma Map.
- O armazenamento principal dos produtos deve ser baseado em uma coleção apropriada.
- Product deve ter equals() e hashCode() coerentes com sua identidade.
- Evite casts desnecessários.
- Use generics adequadamente.
- Crie pelo menos um método que utilize ? extends ou ? super de maneira justificável. Não coloque wildcard apenas para cumprir a exigência.
- Não precisa utilizar Streams ainda. Quero avaliar os fundamentos, não a quantidade de recursos da linguagem utilizados.

O que deve ser entregue?
- As classes relevantes.
- Um pequeno main ou testes manuais demonstrando as operações.
- Uma explicação curta das decisões de design:
- por que escolheu List, Set ou Map para cada responsabilidade;
- qual é a identidade de Product;
- onde e por que usou wildcard;
- quais invariantes seu catálogo tenta manter.



