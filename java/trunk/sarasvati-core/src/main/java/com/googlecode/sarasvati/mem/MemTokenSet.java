/*
    This file is part of Sarasvati.

    Sarasvati is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    Sarasvati is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Sarasvati.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2009 Paul Lorenz
*/

package com.googlecode.sarasvati.mem;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.sarasvati.ArcToken;
import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.GraphProcess;
import com.googlecode.sarasvati.NodeToken;
import com.googlecode.sarasvati.TokenSet;
import com.googlecode.sarasvati.env.Env;
import com.googlecode.sarasvati.env.TokenSetMemberEnv;
import com.googlecode.sarasvati.impl.MapEnv;

public class MemTokenSet implements TokenSet
{
  private final GraphProcess process;
  private final String name;
  private final int maxMemberIndex;
  private final int level;

  private Set<ArcToken> activeArcTokens = new HashSet<ArcToken>();
  private Set<NodeToken> activeNodeTokens = new HashSet<NodeToken>();

  private Env env = new MapEnv();
  private TokenSetMemberEnv memberEnv;

  public MemTokenSet (final GraphProcess process,
                      final String name,
                      final int maxMemberIndex,
                      final int level)
  {
    this.process = process;
    this.name = name;
    this.maxMemberIndex = maxMemberIndex;
    this.level = level;
  }

  @Override
  public String getName ()
  {
    return name;
  }

  @Override
  public GraphProcess getProcess ()
  {
    return process;
  }

  @Override
  public Set<ArcToken> getActiveArcTokens (final Engine engine)
  {
    return activeArcTokens;
  }

  @Override
  public Set<NodeToken> getActiveNodeTokens (final Engine engine)
  {
    return activeNodeTokens;
  }

  @Override
  public int getMaxMemberIndex()
  {
    return maxMemberIndex;
  }

  /**
   * @return the level
   */
  @Override
  public int getLevel()
  {
    return level;
  }

  @Override
  public Env getEnv ()
  {
    return env;
  }

  @Override
  public TokenSetMemberEnv getMemberEnv ()
  {
    if ( memberEnv == null )
    {
      memberEnv = new MemTokenSetMemberEnv( this );
    }
    return memberEnv;
  }
}