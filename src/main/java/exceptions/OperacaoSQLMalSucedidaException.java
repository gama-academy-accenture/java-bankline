package exceptions;

public class OperacaoSQLMalSucedidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OperacaoSQLMalSucedidaException(String mensagem) {
		super(mensagem);
	}

}
