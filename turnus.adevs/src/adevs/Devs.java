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

/**
 * This is the base class for all DEVS models.
 * @see Network
 * @see Atomic
 */
@SuppressWarnings("unused")
public abstract class Devs
{
	/**
	 * This is the Dynamic DEVS model transition function. For Atomic models,
	 * this method is called after each change of the model's state. If the
	 * method returns true, the model_transition method of the model's parent
	 * (a Network) is called. For a Network model, this method may be used
	 * to add and remove components the the model's set of components. Only models
	 * added and removed by the model_transition function are guaranteed to
	 * be properly handled by the Simulator. Method returns false by default.
	 */
	public boolean model_transition() { return false; }
	// This is set by the cpp Simulator to keep track of the C++ peer
	private long cpp_peer;
	// Used by the C++ simulator to typecheck models
	private boolean is_atomic;
	// Get the identification of the native peer. 
	public final long getNativePeer() { return cpp_peer; }
	// Constructor sets the flag for the model's type
	protected Devs(boolean is_atomic)
	{
		this.is_atomic = is_atomic;
		cpp_peer = 0;
	}
}
