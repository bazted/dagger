/*
 * Copyright (C) 2015 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.subcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;

@Module
abstract class ParentModule {
  @Provides
  @IntoSet
  static Object provideUnscopedObject() {
    return new Object() {
      @Override public String toString() {
        return "unscoped in parent";
      }
    };
  }

  @Provides
  @IntoSet
  @Singleton
  static Object provideSingletonObject() {
    return new Object() {
      @Override public String toString() {
        return "singleton";
      }
    };
  }

  @Binds
  @Singleton
  @BoundAsSingleton
  abstract UnscopedType provideUnscopedTypeBoundAsSingleton(UnscopedType unscopedType);
}
