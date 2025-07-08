# Sistema de Gestão de Biblioteca Digital

## ▶ Executar o projeto

```fish
mvn compile exec:java
```

## 📁 Estrutura sugerida do projeto

> [!WARNING]
> Esta estrutura é apenas uma sugestão, provavelmente terá alterações conforme o projeto evolui.

```
/src/main/java/br/edu/ifpb/gestaobibliotecadigital
│
├── 📁app/                         ← Classe principal (main)
│   └── Main.java
│
├── 📁controllers/                ← Controladores Swing (substituindo REST)
│   ├── LoginController.java
│   ├── LivroController.java
│   ├── EmprestimoController.java
│   ├── AvaliacaoController.java
│   └── RelatorioController.java
│
├── 📁views/                      ← Telas Swing
│   ├── LoginView.java
│   ├── CadastroUsuarioView.java
│   ├── ListaLivrosView.java
│   ├── EmprestimoView.java
│   ├── AvaliacaoView.java
│   └── DashboardAdminView.java
│
├── 📁models/                     ← Entidades
│   ├── 📁usuarios/
│   │   ├── Usuario.java
│   │   ├── LeitorComum.java
│   │   ├── LeitorPremium.java
│   │   └── Administrador.java
│   ├── 📁livros/
│   │   ├── Livro.java
│   │   ├── LivroBuilder.java
│   │   ├── Colecao.java           ← Composite
│   │   └── 📁decorators/
│   │       ├── LivroDecorator.java
│   │       ├── LivroComTag.java
│   │       └── LivroDestacado.java
│   ├── 📁emprestimos/
│   │   ├── Emprestimo.java
│   │   ├── Reserva.java
│   │   ├── EstadoLivro.java       ← State
│   │   ├── HistoricoSnapshot.java ← Memento
│   │   └── 📁estrategias/
│   │       ├── EstrategiaEmprestimo.java
│   │       ├── EmprestimoPadrao.java
│   │       └── EmprestimoPremium.java
│   ├── 📁avaliacao/
│   │   ├── Avaliacao.java
│   │   ├── Comentario.java
│   │   ├── Recomendacao.java
│   │   ├── RecomendacaoHandler.java   ← Chain of Responsibility
│   │   ├── FlyweightFactory.java
│   │   └── 📁adapters/
│   │       └── RecomendacaoExternaAdapter.java
│   └── 📁relatorios/
│       ├── Relatorio.java
│       ├── RelatorioPDF.java
│       ├── RelatorioCSV.java
│       ├── RelatorioTemplate.java
│       └── IteratorDados.java
│
├── 📁services/                   ← Lógica de negócio (interfaces + implementações)
│   ├── 📁interfaces/
│   │   ├── IUsuarioService.java
│   │   ├── ILivroService.java
│   │   ├── IEmprestimoService.java
│   │   ├── IAvaliacaoService.java
│   │   └── IRelatorioService.java
│   ├── 📁impl/
│   │   ├── UsuarioService.java
│   │   ├── LivroService.java
│   │   ├── EmprestimoService.java
│   │   ├── AvaliacaoService.java
│   │   └── RelatorioService.java
│
├── 📁repositories/              ← Simula persistência com serialização
│   ├── UsuarioRepository.java
│   ├── LivroRepository.java
│   ├── EmprestimoRepository.java
│   └── AvaliacaoRepository.java
│
├── 📁session/                   ← Sessão atual do usuário (Singleton + Proxy)
│   ├── UserSessionManager.java
│   └── PermissaoProxy.java
│
├── 📁observers/                 ← Observadores
│   ├── Notificacao.java
│   ├── NotificacaoObserver.java
│   ├── LivroObserver.java
│   └── AvaliacaoObserver.java
│
└── 📁utils/                     ← Utilidades
    └── Serializador.java
```
