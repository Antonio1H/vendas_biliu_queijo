## Padrão de Commits

Para manter o histórico do projeto organizado, utilizamos o padrão **Conventional Commits**.

### Formato

```text
tipo: descrição curta
```

### Tipos utilizados

| Tipo       | Quando utilizar                                                 | Exemplo                             |
| ---------- | --------------------------------------------------------------- | ----------------------------------- |
| `feat`     | Nova funcionalidade                                             | `feat: cria entidade Produto`       |
| `fix`      | Correção de um problema/bug                                     | `fix: corrige validação do produto` |
| `refactor` | Organização ou melhoria do código sem alterar seu comportamento | `refactor: organiza classe Produto` |
| `test`     | Criação ou alteração de testes                                  | `test: adiciona testes de Produto`  |
| `docs`     | Alterações na documentação                                      | `docs: atualiza README`             |
| `chore`    | Configurações e tarefas de manutenção                           | `chore: configura projeto inicial`  |

### Exemplos

```bash
git add .
git commit -m "feat: cria entidade Produto"
```

```bash
git add .
git commit -m "fix: corrige validação do produto"
```

```bash
git add .
git commit -m "test: adiciona testes de Produto"
```

### Regra simples

Antes de fazer o commit, pergunte:

* Criei algo novo? → `feat`
* Corrigi algum problema? → `fix`
* Apenas organizei/melhorei o código? → `refactor`
* Fiz ou alterei testes? → `test`
* Alterei documentação? → `docs`
* Fiz configuração/manutenção? → `chore`

### Boas práticas

* Escreva mensagens curtas e objetivas.
* Use o verbo no presente: `cria`, `corrige`, `adiciona`, `atualiza`.
* Evite mensagens genéricas como `mudanças`, `update`, `coisas novas` ou `alterações`.
* Faça commits relacionados a uma alteração específica.
