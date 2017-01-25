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
 * This interface is implemented by atomic DEVS models.
 * The model's constructor should place it
 * into its initial state.
 */
public abstract class Atomic<X> extends Devs
{
	/// Constructor should set the initial state
	public Atomic() { super(true); }
	/// Internal transition function 
	public abstract void delta_int();
	/**
	 * External transition function
	 *
	 * @param e	Time elapsed since the last change of state
	 * @param xb Collection containing the model's input
	 */
	public abstract void delta_ext(double e, Collection<X> xb);
	/**
	 * Confluenct transition function
	 *
	 * @param xb Collection containing the model's input
	 */
	public abstract void delta_conf(Collection<X> xb);
	/**
	 * The output function must fill the Collection yb with the model's output.
	 *
	 * @param yb	An empty Collection to be filled with output from the model
	 */
	public abstract void output_func(Collection<X> yb);
	/**
	 * Time advance. Use Double.MAX_VALUE for infinity.
	 */
	public abstract double ta();
}
