/**
 * Copyright (c) 2013, James Nutaro
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies, 
 * either expressed or implied, of the FreeBSD Project.
 *
 * Bugs, comments, and questions can be sent to nutaro@gmail.com
 */
package adevs;
import java.util.Collection;

/**
 * This is the base class for all Network (coupled) models.
 */
public abstract class Network extends Devs
{
	public Network()
	{
		super(false);
	}
	/**
	 * The collection must be Fill with Network's components.
	 * Duplicates will be ignored by the simulator. Unlike
	 * the C++ simulator, the parent of a component is
	 * automatically set to be the Network whose set of
	 * components it appears in.
	 *
	 * @param	c	Empty collection to fill with the Network's components
	 */
	public abstract void getComponents(Collection<Devs> c);
	/**
	 * Route events coming into to the model or being produced
	 * by one of its components. The collection is filled with
	 * events whose model field is the target of its value field.
	 *
	 * @param	x	The value of the event to be routed
	 * @param	model	The source of the event
	 * @param	r	An empty collection to be filled with (target,value) pairs
	 * @see	Event
	 */
	public abstract void route(Object x, Devs model, Collection<Event> r);
}
