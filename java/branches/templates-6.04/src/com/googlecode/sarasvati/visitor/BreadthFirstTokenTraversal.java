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

    Copyright 2008 Paul Lorenz
*/

package com.googlecode.sarasvati.visitor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.googlecode.sarasvati.ArcToken;
import com.googlecode.sarasvati.NodeToken;

public class BreadthFirstTokenTraversal implements TokenTraversal
{
  protected LinkedList<NodeToken> nodeTokenQueue = new LinkedList<NodeToken>();
  protected LinkedList<ArcToken> arcTokenQueue = new LinkedList<ArcToken>();

  protected Set<Long> nodeTokens = new HashSet<Long>();

  @Override
  public void traverse (NodeToken token, TokenVisitor visitor)
  {
    enqueueNodeToken( token );
    traverse( visitor );
  }

  @Override
  public void traverse (ArcToken token, TokenVisitor visitor)
  {
    arcTokenQueue.add( token );
    traverse( visitor );
  }

  protected void traverse (TokenVisitor visitor)
  {
    while ( !nodeTokenQueue.isEmpty() || !arcTokenQueue.isEmpty() )
    {
      while ( !nodeTokenQueue.isEmpty() )
      {
        NodeToken token = nodeTokenQueue.removeFirst();
        token.accept( visitor );
        arcTokenQueue.addAll( token.getChildTokens() );
      }

      while ( !arcTokenQueue.isEmpty() )
      {
        ArcToken token = arcTokenQueue.removeFirst();

        if ( visitor.follow( token ) )
        {
          token.accept( visitor );
          enqueueNodeToken( token.getChildToken() );
        }
      }
    }
  }

  protected void enqueueNodeToken (NodeToken token)
  {
    if ( token != null && !nodeTokens.contains( token.getId() ) )
    {
      nodeTokenQueue.add( token );
      nodeTokens.add( token.getId() );
    }
  }
}