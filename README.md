# Desafio Técnico: Implementação de um Programa WEB para Gerenciamento de Dados de Pessoas

Este projeto tem como objetivo desenvolver um programa WEB para gerenciar dados de pessoas, implementando operações de CRUD (Create, Read, Update, Delete) e fornecendo saída de dados para diversas situações. Abaixo estão detalhadas as decisões técnicas e arquiteturais adotadas, assim como as instruções para compilar, executar e testar o projeto.

## Decisões Técnicas e Arquiteturais

- **Framework Web**: O framework escolhido para desenvolver a aplicação web é o Java Server Faces (JSF), com preferência para a utilização do framework PrimeFaces devido à sua ampla gama de componentes visuais e facilidades de integração.
- **Banco de Dados**: Foi escolhido o banco de dados relacional PostgreSQL devido à sua confiabilidade, desempenho e recursos avançados.
- **JPA e Hibernate**: Para persistência de dados, será utilizada a implementação de JPA, com preferência para o Hibernate devido à sua popularidade e suporte à especificação JPA.
- **Injeção de Dependências**: Será utilizada a injeção de dependências, preferencialmente utilizando EJB (Enterprise JavaBeans), para facilitar a gerência de componentes e promover a modularidade do código.
- **Estrutura do Projeto**: A arquitetura do projeto seguirá os princípios de modularidade e separação de preocupações, seguindo as convenções do padrão MVC (Model-View-Controller) para a organização dos componentes.
- **Utilização do Maven**: O Maven foi escolhido como a ferramenta de automação de compilação e gerenciamento de dependências do projeto. Através do arquivo pom.xml, pude definir as dependências necessárias para as tecnologias utilizadas, como o JSF, PrimeFaces, Hibernate, entre outros. Além disso, o Maven simplificou a configuração do ambiente de desenvolvimento, permitindo a fácil integração com o Apache TomEE e simplificando a implantação do projeto. No entanto, apesar de suas vantagens, a configuração do Maven exigiu um tempo significativo para garantir que todas as dependências e plugins estivessem corretamente configurados para atender aos requisitos do projeto.

## Justificativa para o Projeto Não Funcionar Completo

Infelizmente, não foi possível concluir e fazer funcionar o projeto inteiro devido a algumas dificuldades encontradas durante o processo de desenvolvimento. Abaixo estão algumas razões que contribuíram para isso:

- Falta de Experiência Prévia: Não possuía experiência prévia com todas as tecnologias e frameworks especificados no desafio, como Java Server Faces (JSF), PrimeFaces, Hibernate e o EJB. Isso resultou em um tempo significativo investido na aprendizagem dessas tecnologias, o que acabou impactando o progresso do projeto.
- Complexidade das Integrações: A integração entre diferentes tecnologias e frameworks, como a configuração do Hibernate com o PostgreSQL, a configuração do EJB com o JSF, entre outros, provou ser mais complexa do que inicialmente previsto. Isso levou a dificuldades na configuração correta dessas integrações e consequentemente na funcionalidade adequada do sistema.
- Problemas de Configuração e Ambiente: Enfrentei problemas relacionados à configuração do ambiente de desenvolvimento, como instalação e configuração do Docker, configuração do servidor de aplicação TomEE, entre outros. Esses problemas consumiram tempo precioso e dificultaram o progresso do projeto.
- Tempo Limitado: O desafio técnico foi realizado em um período de tempo limitado, o que não permitiu a resolução de todas as dificuldades encontradas e a conclusão do projeto dentro do prazo estipulado.

Embora não tenha sido possível fazer o projeto funcionar completamente, essa experiência proporcionou uma oportunidade valiosa para aprender novas tecnologias e enfrentar desafios técnicos, o que contribuirá para o crescimento profissional e para futuros projetos.

## Experiências
Durante o desenvolvimento deste projeto, me empenhei ao máximo em tentar fazer com que ele fosse concluído até o último momento. Enfrentei diversos desafios e obstáculos ao longo do caminho, incluindo a familiarização com tecnologias e frameworks que eu ainda não tinha experiência prévia, como Java Server Faces (JSF), PrimeFaces, PostgreSQL, Hibernate, entre outros.
Cada dificuldade encontrada foi encarada como uma oportunidade de aprendizado. Dediquei horas de leitura, estudo e prática para compreender melhor os conceitos e funcionalidades dessas tecnologias, buscando superar cada obstáculo de forma proativa e determinada. Mesmo diante das frustrações e contratempos, mantive-me focada e comprometida em encontrar soluções e avançar no desenvolvimento do projeto.
Essa jornada de aprendizado foi incrivelmente positiva para o meu crescimento profissional e pessoal. A cada desafio superado, adquiri novos conhecimentos e habilidades que ampliaram minha compreensão do mundo Java e me tornaram uma desenvolvedora mais versátil e capacitada.
Gostaria de enfatizar que, apesar de não ter conseguido concluir o projeto dentro do prazo estipulado, minha disposição para aprender e minha determinação em enfrentar desafios permanecem inabaláveis. Estou convencida de que fazer parte deste time seria uma oportunidade única para fechar os elos do mundo Java em todas as circunstâncias, contribuindo com meu entusiasmo, dedicação e conhecimento adquirido para o sucesso do projeto e o crescimento contínuo da equipe.
Estou ansiosa para a possibilidade de me juntar ao time e continuar minha jornada de aprendizado e desenvolvimento ao lado de profissionais experientes e apaixonados pelo que fazem.
