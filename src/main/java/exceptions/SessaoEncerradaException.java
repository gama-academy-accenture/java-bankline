package exceptions;

public class SessaoEncerradaException extends RuntimeException {
	public SessaoEncerradaException(String mensagem) {
		super(mensagem);
	}

}
