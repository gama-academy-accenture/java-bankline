package exceptions;

public class SessaoEncerradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SessaoEncerradaException(String mensagem) {
		super(mensagem);
	}

}
