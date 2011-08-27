/*
    This file is part of Opes.

    Opes is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Opes is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Opes.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.insula.opes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelefoneTest {

	@Test
	public void testFromString() {
		assertNotNull(Telefone.fromString("(44) 4052-9211"));
		assertNotNull(Telefone.fromString("4052-9211"));
		assertNotNull(Telefone.fromString("14052-9211"));
		assertNotNull(Telefone.fromString("+55 (44) 4052-9211"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromStringWithLessDigits() {
		Telefone.fromString("1234567");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromStringWithMoreDigits() {
		Telefone.fromString("12345678901234");
	}

	@Test
	public void testToString() {
		assertEquals("4052-9211", Telefone.fromString("40529211").toString());
		assertEquals("1405-29211", Telefone.fromString("140529211").toString());
		assertEquals("(44) 4052-9211", Telefone.fromString("4440529211").toString());
		assertEquals("(44) 4052-92110", Telefone.fromString("44405292110").toString());
		assertEquals("+55 (44) 4052-9211", Telefone.fromString("554440529211").toString());
		assertEquals("+55 (44) 4052-92110", Telefone.fromString("5544405292110").toString());
	}

}