package br.com.fatecmc.esiii.imp;

import java.sql.Connection;
import br.com.fatecmc.esiii.dao.IDAO;

public abstract class AbstractDAO implements IDAO {
	protected Connection connection;
}
